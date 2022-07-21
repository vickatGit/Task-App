package com.example.tasKAppDB.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer list_id;
    String name;
    String description;
    boolean isActive;

    @OneToMany(mappedBy = "taskList",cascade = CascadeType.ALL,orphanRemoval = true)
    List<Task> tasks;

    @JsonManagedReference
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList(Integer list_id, String name, String description, boolean isActive, List<Task> tasks) {
        this.list_id = list_id;
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.tasks = tasks;
    }

    public TaskList(String name, String description, boolean isActive) {
        this.name = name;
        this.description = description;
        this.isActive = isActive;
    }

    public Integer getList_id() {
        return list_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "list_id=" + list_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                ", tasks=" + tasks +
                '}';
    }

    public TaskList() {
    }
}
