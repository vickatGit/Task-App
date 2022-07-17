package com.example.tasKAppDB.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer taskId;
    String taskName;
    String description;
    Date dueDate;
    String period;
    String periodType;
    @ManyToOne
    @JoinColumn(name = "list_id")
    TaskList taskl;

    @JsonBackReference
    public TaskList getTaskl() {
        return taskl;
    }

    public void setTaskl(TaskList taskl) {
        this.taskl = taskl;
    }



    public Task( TaskList tasklist,String taskName, String description, Date dueDate, String period, String periodType) {
        this.taskl =tasklist;
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
        this.period = period;
        this.periodType = periodType;
    }

    public Task( String taskName, String description, Date dueDate, String period, String periodType) {
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
        this.period = period;
        this.periodType = periodType;
    }

    public Task(Integer taskId, String taskName, String description, Date dueDate, String period, String periodType) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
        this.period = period;
        this.periodType = periodType;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", period='" + period + '\'' +
                ", periodType='" + periodType + '\'' +
                '}';
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }



    public Task() {
    }
}
