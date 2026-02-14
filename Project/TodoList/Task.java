package com.Project.TodoList;

/*
| **Column Name** | **MySQL Datatype**            | **Java Datatype**                                  | **Reason**                          |
| --------------- | ----------------------------- | -------------------------------------------------- | ----------------------------------- |
| `task_id`       | `INT AUTO_INCREMENT`          | `int` or `Integer`                                 | Simple numeric primary key          |
| `task_status`   | `ENUM('PENDING','COMPLETED')` | `String`                                           | Enum values come as strings in JDBC |
| `created_date`  | `DATE`                        | `java.sql.Date`                                    | MySQL DATE → JDBC Date object       |
| `completed_at`  | `DATE` (nullable)             | `java.sql.Date` (nullable → can be null reference) | DATE type                           |
| `deadline`      | `DATE`                        | `java.sql.Date`                                    | DATE type                           |
*/

import java.sql.Date;

public class Task {
    private Integer task_id;
    private String taskName="NULL_--";
    private String  task_status;
    private Date created_date;
    private  Date completed_at;
    private  Date deadline;



    public Task(Integer task_id, String taskName, String task_status, Date created_date, Date completed_at, Date deadline) {
        this.task_id = task_id;
        this.taskName = taskName;
        this.task_status = task_status;
        this.created_date = created_date;
        this.completed_at = completed_at;
        this.deadline = deadline;
    }


    public Task() {

    }


    public Task(Integer task_id, String task_status, Date created_date, Date completed_at, Date deadline) {
        this.task_id = task_id;
        this.task_status = task_status;
        this.created_date = created_date;
        this.completed_at = completed_at;
        this.deadline = deadline;
    }
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public void setTask_status(String task_status) {
        this.task_status = task_status;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public void setCompleted_at(Date completed_at) {
        this.completed_at = completed_at;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getTask_id() {
        return task_id;
    }

    public String getTask_status() {
        return task_status;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public Date getCompleted_at() {
        return completed_at;
    }

    public Date getDeadline() {
        return deadline;
    }
}
