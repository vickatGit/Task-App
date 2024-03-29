package com.example.tasKAppDB.Controller;

import com.example.tasKAppDB.Dao.TaskListDao;
import com.example.tasKAppDB.Model.Task;
import com.example.tasKAppDB.Model.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskListController {
    @Autowired
    TaskListDao dao;

    @GetMapping("/TaskLists/getTaskLists")
    public List<TaskList> getTaskLists(){
        return dao.getTaskLists();
    }

    @PostMapping("/TaskLists/addTaskList")
    public TaskList addTaskList(@RequestBody TaskList taskList){
        System.out.println(taskList.toString());
        return dao.addTaskList(taskList);
    }

    @GetMapping("/TaskLists/deleteTaskList/{taskListId}")
    public void deleteTaskList(@PathVariable String taskListId ){
        dao.deleteTaskList(taskListId);
    }
    @PutMapping("/TaskLists/updateTaskList")
    public TaskList updateTaskList(@RequestBody TaskList taskList){
        return dao.updateTaskList(taskList);
    }



    @GetMapping("/TaskLists/findTask/{listId}")
    public List<Task> getTask(@PathVariable String listId){
        return dao.getTask(listId);
    }

    @PostMapping("/TaskLists/addTask")
    public Task addTask(@RequestBody Task task){
        System.out.println("-------------------------ADD TASK------------------------------------------");
        System.out.println(task.toString());
        System.out.println("-------------------------ADD TASK------------------------------------------");
        return dao.addTask(task);
    }

    @GetMapping("/TaskLists/Tasks")
    public List<Task> getTasks(){

        return dao.getTasks();
    }

    @GetMapping("/TaskLists/deleteTask/{task_id}")
    public void deleteTask(@PathVariable("task_id") String task_id){
    	System.out.println(task_id);
        dao.deleteTask(task_id);
    }

    @PutMapping("/TaskLists/updateTask")
    public Task updateTask(@RequestBody Task task){
        return dao.updateTask(task);
    }
}
