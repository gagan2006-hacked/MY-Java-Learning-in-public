package com.Project.TodoList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/*
1. CRUD Operations
| Feature      | Method Name             | Purpose             | Returns          | Notes                             |
| ------------ | ----------------------- | ------------------- | ---------------- | --------------------------------- |
| Create Task  | `addTask(Task task)`    | Insert new task     | `boolean`        | Auto-set created_date if null     |
| Read (by id) | `getTaskById(int id)`   | Fetch a single task | `Optional<Task>` | Returns empty if not found        |
| Read (all)   | `getAllTasks()`         | Get all tasks       | `List<Task>`     | Ordered by task_id                |
| Update Task  | `updateTask(Task task)` | Update all fields   | `boolean`        | Validates deadline > created_date |
| Delete Task  | `deleteTask(int id)`    | Remove task         | `boolean`        | Checks if row exists              |

2. Status / Category Filters
| Feature             | Method Name                 | Purpose                              | Returns      |
| ------------------- | --------------------------- | ------------------------------------ | ------------ |
| Get completed tasks | `getCompletedTasks()`       | tasks with `task_status='COMPLETED'` | `List<Task>` |
| Get pending tasks   | `getPendingTasks()`         | tasks not completed                  | `List<Task>` |
| Mark task completed | `markTaskCompleted(int id)` | Set status + auto set completed_at   | `boolean`    |

3. Search Features
| Feature            | Method Name                                | Purpose                    | Returns      |
| ------------------ | ------------------------------------------ | -------------------------- | ------------ |
| Search by status   | `searchTasksByStatus(String status)`       | Search PENDING / COMPLETED | `List<Task>` |
| Search by deadline | `searchTasksByDeadline(Date date)`         | Find tasks due on date     | `List<Task>` |
| Search date range  | `searchTasksBetween(Date start, Date end)` | Filter by deadline range   | `List<Task>` |

4. Pagination (for large data)
| Feature           | Method Name                       | Purpose                         | Returns      |
| ----------------- | --------------------------------- | ------------------------------- | ------------ |
| Paginated results | `getTasks(int offset, int limit)` | Efficient large table scrolling | `List<Task>` |

5. Stored Procedure Access
| Feature             | Method Name                   | Purpose                | Returns  |
| ------------------- | ----------------------------- | ---------------------- | -------- |
| Completion accuracy | `getTaskCompletionAccuracy()` | Calls stored procedure | `double` |

*/


public class TaskDao {
    private static final String URL = "jdbc:mysql://localhost:3306/todo";
    private static final String USER = "root";
    private static final String PASSWORD = "gagan@2006vishwa";
    private Connection  connection;

    public TaskDao() throws RuntimeException {
        try {
            connection= DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    1. CRUD Operations
    public boolean addTask(Task task){
        String sql = "INSERT INTO task (task_status, created_date, completed_at, deadline,taskName) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, task.getTask_status());
            ps.setDate(2, task.getCreated_date());
            ps.setDate(3, task.getCompleted_at()); // can be null
            ps.setDate(4, task.getDeadline());
            ps.setString(5,task.getTaskName());
            int rows = ps.executeUpdate();
            return rows > 0;
        }catch (SQLException e){
            return false;
        }
    }

    public Task getTaskById(int id) {
        String sql = "SELECT task_id, task_status, created_date, completed_at, deadline,taskName FROM task WHERE task_id = ?";
        Task task = null;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                task = new Task();
                task.setTask_id(rs.getInt("task_id"));
                task.setTaskName(rs.getString("taskName"));
                task.setTask_status(rs.getString("task_status"));
                task.setCreated_date(rs.getDate("created_date"));
                task.setCompleted_at(rs.getDate("completed_at"));   // can be null
                task.setDeadline(rs.getDate("deadline"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return task;
    }

    public List<Task>  getAllTasks(){
        String sql = "SELECT task_id, task_status, created_date, completed_at, deadline,taskName FROM task";
        List<Task>list=new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Task task = new Task();
                task.setTask_id(rs.getInt("task_id"));
                task.setTaskName(rs.getString("taskName"));
                task.setTask_status(rs.getString("task_status"));
                task.setCreated_date(rs.getDate("created_date"));
                task.setCompleted_at(rs.getDate("completed_at"));   // can be null
                task.setDeadline(rs.getDate("deadline"));
                list.add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateTask(Task task) {
        String sql = "UPDATE task SET task_status = ?, created_date = ?, completed_at = ?, deadline = ?,taskName=? WHERE task_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, task.getTask_status());
            ps.setDate(2, task.getCreated_date());
            ps.setDate(3, task.getCompleted_at());  // can be null
            ps.setDate(4, task.getDeadline());
            ps.setInt(6, task.getTask_id());
            ps.setString(5,task.getTaskName());
            int rows = ps.executeUpdate();
            return rows > 0;   // true if update successful

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteTask(int id) {
        String sql = "DELETE FROM task WHERE task_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            return rows > 0;  // true if at least one row deleted

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

//    2. Status / Category Filters
    public List<Task> getCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();

        String sql = "SELECT task_id, task_status, created_date, completed_at, deadline,taskName " +
                "FROM task WHERE task_status = 'COMPLETED'";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Task task = new Task();
                task.setTask_id(rs.getInt("task_id"));
                task.setTaskName(rs.getString("taskName"));
                task.setTask_status(rs.getString("task_status"));
                task.setCreated_date(rs.getDate("created_date"));
                task.setCompleted_at(rs.getDate("completed_at"));
                task.setDeadline(rs.getDate("deadline"));

                completedTasks.add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return completedTasks;
    }

    public List<Task> getPendingTasks() {
        List<Task> pendingTasks = new ArrayList<>();

        String sql = "SELECT task_id, task_status, created_date, completed_at, deadline,taskName " +
                "FROM task WHERE task_status = 'PENDING'";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Task task = new Task();
                task.setTask_id(rs.getInt("task_id"));
                task.setTaskName(rs.getString("taskName"));
                task.setTask_status(rs.getString("task_status"));
                task.setCreated_date(rs.getDate("created_date"));
                task.setCompleted_at(rs.getDate("completed_at")); // should normally be null
                task.setDeadline(rs.getDate("deadline"));

                pendingTasks.add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pendingTasks;
    }

    public boolean markTaskCompleted(int id) {
        String sql = "UPDATE task SET task_status = 'COMPLETED', completed_at = CURRENT_DATE WHERE task_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            return rows > 0;  // true if task was updated

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

//    3. Search Features
    public List<Task> searchTasksByStatus(String status) {
        List<Task> tasks = new ArrayList<>();

        String sql = "SELECT task_id, task_status, created_date, completed_at, deadline,taskName "
                + "FROM task WHERE task_status = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, status);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Task task = new Task();
                task.setTask_id(rs.getInt("task_id"));
                task.setTaskName(rs.getString("taskName"));
                task.setTask_status(rs.getString("task_status"));
                task.setCreated_date(rs.getDate("created_date"));
                task.setCompleted_at(rs.getDate("completed_at"));
                task.setDeadline(rs.getDate("deadline"));

                tasks.add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }

    public List<Task> searchTasksByDeadline(Date date) {
        List<Task> tasks = new ArrayList<>();

        String sql = "SELECT task_id, task_status, created_date, completed_at, deadline,taskName "
                + "FROM task WHERE deadline = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDate(1, date); // java.sql.Date

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Task task = new Task();
                task.setTask_id(rs.getInt("task_id"));
                task.setTaskName(rs.getString("taskName"));
                task.setTask_status(rs.getString("task_status"));
                task.setCreated_date(rs.getDate("created_date"));
                task.setCompleted_at(rs.getDate("completed_at"));
                task.setDeadline(rs.getDate("deadline"));


                tasks.add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }

    public List<Task> searchTasksBetween(Date start, Date end) {
        List<Task> tasks = new ArrayList<>();

        String sql = "SELECT task_id, task_status, created_date, completed_at, deadline,taskName "
                + "FROM task WHERE deadline BETWEEN ? AND ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDate(1, start); // java.sql.Date
            ps.setDate(2, end);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Task task = new Task();
                task.setTask_id(rs.getInt("task_id"));
                task.setTaskName(rs.getString("taskName"));
                task.setTask_status(rs.getString("task_status"));
                task.setCreated_date(rs.getDate("created_date"));
                task.setCompleted_at(rs.getDate("completed_at"));
                task.setDeadline(rs.getDate("deadline"));

                tasks.add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }

//    4. Pagination (for large data)
    public List<Task> getTasks(int offset, int limit) {
        List<Task> tasks = new ArrayList<>();

        String sql = "SELECT task_id, task_status, created_date, completed_at, deadline,taskName "
                + "FROM task ORDER BY task_id LIMIT ? OFFSET ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, limit);
            ps.setInt(2, offset);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Task task = new Task();
                task.setTask_id(rs.getInt("task_id"));
                task.setTaskName(rs.getString("taskName"));
                task.setTask_status(rs.getString("task_status"));
                task.setCreated_date(rs.getDate("created_date"));
                task.setCompleted_at(rs.getDate("completed_at"));
                task.setDeadline(rs.getDate("deadline"));

                tasks.add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }

//    5. Stored Procedure Access
    public Double getTaskCompletionAccuracy() {
        String sql = " CALL task_completion_accuracy(); ";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                double accuracy = rs.getDouble("accuracy_percentage");

                // If NULL (meaning no tasks completed), return 0
                if (rs.wasNull()) return 0.0;

                return accuracy;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0.0;
    }
}

