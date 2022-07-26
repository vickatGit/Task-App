package com.example.task.ViewModels

import androidx.lifecycle.ViewModel
import com.example.task.Network.NetworkModels.Task
import com.example.task.Repository.Repository

class TaskViewerActivityViewModel:ViewModel() {
    private lateinit var repo:Repository
    init {
        repo= Repository()
    }
    fun delteTask(task_id:Int) {
        repo.deleteTask(task_id)
    }

}