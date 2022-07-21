package com.example.task.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.Network.NetworkModels.Task
import com.example.task.Network.NetworkModels.TaskLists
import com.example.task.Repository.Repository

class AddTaskViewModel:ViewModel() {
    private lateinit var repo: Repository
    public lateinit var allTaskLists: MutableLiveData<List<TaskLists>>
    init {
        repo= Repository()
//        repo.addTaskList(TaskLists(true,"adding tasklist through retrofit",null,"retro taskList",null))
    }

    fun addTask(task: Task){
        repo.addTask(task)
    }
}