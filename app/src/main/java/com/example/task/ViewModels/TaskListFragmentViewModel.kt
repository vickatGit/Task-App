package com.example.task.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task.Network.NetworkModels.TaskLists
import com.example.task.Repository.Repository

class TaskListFragmentViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private lateinit var repo:Repository
    public lateinit var allTaskLists: MutableLiveData<List<TaskLists>>
    init {
        repo= Repository()
        allTaskLists= repo.getTaskLists() as MutableLiveData<List<TaskLists>>
    }

    fun getTaskLists():MutableLiveData<List<TaskLists>>{
        return allTaskLists
    }

}