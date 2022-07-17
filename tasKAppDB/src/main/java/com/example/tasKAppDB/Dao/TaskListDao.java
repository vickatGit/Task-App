package com.example.tasKAppDB.Dao;

import com.example.tasKAppDB.Model.Task;
import com.example.tasKAppDB.Model.TaskList;
import com.example.tasKAppDB.Repository.TaskListRepo;
import com.example.tasKAppDB.Repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskListDao {
    @Autowired
    TaskListRepo repo;
    @Autowired
    TaskRepo taskRepo;

    public List<TaskList> getTaskLists(){
        return repo.findAll();
    }
    public TaskList addTaskList(TaskList taskList){
        return repo.save(taskList);
    }
    public TaskList updateTaskList(TaskList taskList) {
        System.out.println(taskList.toString());
        System.out.println(repo.findById(2));
        return repo.save(taskList);
//        return null;
    }

    public Task addTask(Task task) {
        return taskRepo.save(task);

    }

    public List<Task> getTasks() {
        return Streamable.of(taskRepo.findAll()).stream().toList();

    }

    public List<Task> getTask(String taskId) {
        return taskRepo.findTasksByListId(Integer.parseInt(taskId));
    }

    public void deleteTaskList(String taskListId) {
        repo.deleteById(Integer.parseInt(taskListId));
    }
    public Task updateTask(Task task){
        return taskRepo.save(task);
    }

    public void deleteTask(String task_id) {
        taskRepo.deleteById(Integer.parseInt(task_id));
    }


}
