package com.Project.TodoList;

import com.Project.FIle_Encrypt.EncryptionV1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.List;

public class TaskManagerGUI extends JFrame {

    private TaskDao taskDAO;
    private JTable table;
    private DefaultTableModel model;
    ImageIcon icon=new ImageIcon("C:\\Users\\GAGAN\\Downloads\\Icon.jpg");
    private static final String pass="!=#2|1/12|99&|~12#|%#3$|1/12|_0:1!|N8|N6|N6|N7|";
    private EncryptionV1 v1;

    public TaskManagerGUI() {
        String password=JOptionPane.showInputDialog(this,"Enter the password to Open");
        v1=new EncryptionV1();
        String p=v1.decrypt(pass);
        if (password==null||!password.equals(p)){
            JOptionPane.showMessageDialog(null,"Wrong PassWord ?","You Have Entered Wrong Password",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        taskDAO = new TaskDao();

        setTitle("ToDo List Manager");
        setSize(900, 600);
        setIconImage(icon.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Table model
        model = new DefaultTableModel(new String[]{
                "ID","Name", "Status", "Created Date", "Completed At", "Deadline"
        }, 0);

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Top Panel Buttons
        JPanel topPanel = new JPanel();
        JButton addBtn = new JButton("Add Task");
        JButton updateBtn = new JButton("Update Task");
        JButton deleteBtn = new JButton("Delete Task");
        JButton completedBtn = new JButton("Mark Completed");
        JButton refreshBtn = new JButton("Refresh");
        JButton pendingBtn = new JButton("Show Pending");
        JButton completedListBtn = new JButton("Show Completed");
        JButton report=new JButton("Report");

        topPanel.add(addBtn);
        topPanel.add(updateBtn);
        topPanel.add(deleteBtn);
        topPanel.add(completedBtn);
        topPanel.add(refreshBtn);
        topPanel.add(pendingBtn);
        topPanel.add(completedListBtn);
        topPanel.add(report);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Load data initially
        showPending();

        // Event Listeners
        addBtn.addActionListener(e -> addTask());
        updateBtn.addActionListener(e -> updateTask());
        deleteBtn.addActionListener(e -> deleteTask());
        completedBtn.addActionListener(e -> markCompleted());
        pendingBtn.addActionListener(e -> showPending());
        completedListBtn.addActionListener(e -> showCompleted());
        refreshBtn.addActionListener(e -> loadTasks());
        report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double d= taskDAO.getTaskCompletionAccuracy();
                JOptionPane.showMessageDialog(null,"Accuracy of Your on time task Completion  is = "+d+" %");
            }
        });

        addBtn.setFocusable(false);
        updateBtn.setFocusable(false);
        deleteBtn.setFocusable(false);
        completedBtn.setFocusable(false);
        pendingBtn.setFocusable(false);
       completedListBtn.setFocusable(false);
       refreshBtn.setFocusable(false);
       report.setFocusable(false);

       

    }

    private void loadTasks() {
        model.setRowCount(0);
        List<Task> tasks = taskDAO.getAllTasks();
        for (Task t : tasks) {
            model.addRow(new Object[]{
                    t.getTask_id(),
                    t.getTaskName(),
                    t.getTask_status(),
                    t.getCreated_date(),
                    t.getCompleted_at(),
                    t.getDeadline()
            });
        }
    }

    private void addTask() {
        String taskName=JOptionPane.showInputDialog(this,"Enter the Task Name");
        String deadline = JOptionPane.showInputDialog(this, "Enter Deadline (YYYY-MM-DD):");
        if (deadline == null || deadline.isEmpty()) {
            JOptionPane.showMessageDialog(this,"Invalid Input of Date");
            return;
        }
        Task t = new Task();
        t.setDeadline(Date.valueOf(deadline));
        t.setCreated_date(new Date(System.currentTimeMillis()));
        t.setTask_status("PENDING");
        t.setTaskName(taskName);

        if (taskDAO.addTask(t)) {
            JOptionPane.showMessageDialog(this, "Task Added!");
            loadTasks();
        }
    }

    private void updateTask() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a task to update.");
            return;
        }

        int id = (int) model.getValueAt(row, 0);
        String ch=JOptionPane.showInputDialog(this, "Do You want to Update  This Task ? (yes/no) (y/n) ");
        boolean yes=ch.equalsIgnoreCase("yes")||ch.equalsIgnoreCase("y");
        Task task = taskDAO.getTaskById(id);
        boolean bool=yes;

        while (yes){
            String choice=JOptionPane.showInputDialog(this,"Enter the Attribute of Task to update");

            if (choice.equalsIgnoreCase("Name")){
                String enter=JOptionPane.showInputDialog(this,"Do you want change the name of task","Name change Confirmation");
                if (enter.equalsIgnoreCase("yes")||enter.equalsIgnoreCase("y")){
                    String taskName=JOptionPane.showInputDialog(this,"Enter the Task Name");
                    task.setTaskName(taskName);
                }
            } else if (choice.equalsIgnoreCase("Deadline")) {
                String enter=JOptionPane.showInputDialog(this,"Do you want change the Deadline of task","DeadLine change Confirmation");
                if (enter.equalsIgnoreCase("yes")||enter.equalsIgnoreCase("y")){
                    String deadline = JOptionPane.showInputDialog(this, "New Deadline (YYYY-MM-DD):");
                    task.setDeadline(Date.valueOf(deadline));
                }
            }
            else if (choice.equalsIgnoreCase("Status")) {
                String enter=JOptionPane.showInputDialog(this,"Do you want change the Status of task","Status change Confirmation");
                if (enter.equalsIgnoreCase("yes")||enter.equalsIgnoreCase("y")){
                    String status=JOptionPane.showInputDialog(this,"Enter the Status of the Task (PENDING/COMPLETED)");
                    if (status.equalsIgnoreCase("COMPLETED")||status.equalsIgnoreCase("PENDING")){
                        task.setTask_status(status.toUpperCase());
                        if (status.equalsIgnoreCase("PENDING")){
                            task.setCompleted_at(null);
                        }else {
                            if (taskDAO.markTaskCompleted(id)) {
                                JOptionPane.showMessageDialog(this, "Task Marked Completed!");
                                loadTasks();
                            }
                        }
                    }
                }
            }
            ch=JOptionPane.showInputDialog(this, "Do You want to Update  This Task ? (yes/no) (y/n) ");
            yes=ch.equalsIgnoreCase("yes")||ch.equalsIgnoreCase("y");
        }

        if (bool&&taskDAO.updateTask(task)) {
            JOptionPane.showMessageDialog(this, "Task Updated!");
            loadTasks();
            return;
        }
        JOptionPane.showMessageDialog(this,"Error Has Occurred","Error Message",JOptionPane.ERROR_MESSAGE);
    }

    private void deleteTask() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a task to delete.");
            return;
        }

        int id = (int) model.getValueAt(row, 0);

        String con=JOptionPane.showInputDialog(this, "Do You want to Delete This Task ? (yes/no) (y/n) ");
        boolean yes=con.equalsIgnoreCase("yes")||con.equalsIgnoreCase("y");
        if (yes&&taskDAO.deleteTask(id)) {
            JOptionPane.showMessageDialog(this, "Task Deleted!");
            loadTasks();
        }
    }

    private void markCompleted() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a task to mark as completed.");
            return;
        }

        int id = (int) model.getValueAt(row, 0);

        if (taskDAO.markTaskCompleted(id)) {
            JOptionPane.showMessageDialog(this, "Task Marked Completed!");
            loadTasks();
        }
    }

    private void showPending() {
        model.setRowCount(0);
        List<Task> tasks = taskDAO.getPendingTasks();
        for (Task t : tasks) {
            model.addRow(new Object[]{
                    t.getTask_id(),
                    t.getTaskName(),
                    t.getTask_status(),
                    t.getCreated_date(),
                    t.getCompleted_at(),
                    t.getDeadline()
            });
        }
    }

    private void showCompleted() {
        model.setRowCount(0);
        List<Task> tasks = taskDAO.getCompletedTasks();
        for (Task t : tasks) {
            model.addRow(new Object[]{
                    t.getTask_id(),
                    t.getTaskName(),
                    t.getTask_status(),
                    t.getCreated_date(),
                    t.getCompleted_at(),
                    t.getDeadline()
            });
        }
    }

    public static void main(String[] args) {
        new TaskManagerGUI().setVisible(true);
    }
}
