package com.example.task.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.task.Network.NetworkModels.TaskLists
import com.example.task.Network.RetroHelper
import com.example.task.Network.TaskRetro
import retrofit2.*

class Repository {
    private lateinit var retro:TaskRetro
    private lateinit var allTaskLists:MutableLiveData<List<TaskLists>>


    constructor(){
        retro=RetroHelper.getInstance().create(TaskRetro::class.java)
    }
    fun getTaskLists():LiveData<List<TaskLists>>{
        var results:List<TaskLists>
        results= retro.getTaskLists().body()!!
        allTaskLists.postValue(results)
        return allTaskLists


    }
}