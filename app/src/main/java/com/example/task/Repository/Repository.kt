package com.example.task.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.task.Network.NetworkModels.Task
import com.example.task.Network.NetworkModels.TaskLists
import com.example.task.Network.RetroHelper
import com.example.task.Network.TaskRetro
import okhttp3.RequestBody
import retrofit2.*

class Repository {
    private lateinit var retro:TaskRetro
    private val allTaskLists= MutableLiveData<List<TaskLists>>()

    companion object{
        private val TAG="tag"
    }


    constructor(){
        retro=RetroHelper.getInstance().create(TaskRetro::class.java)
    }
    fun getTaskLists():LiveData<List<TaskLists>>{
        var results:List<TaskLists>
        Log.d(TAG, "getTaskLists: ")
        retro.getTaskLists().enqueue(object : Callback<List<TaskLists>>{
            override fun onResponse(
                call: Call<List<TaskLists>>,
                response: Response<List<TaskLists>>
            ) {
                allTaskLists.postValue(response.body())
                Log.d(TAG, "onResponse: "+response.body())
            }

            override fun onFailure(call: Call<List<TaskLists>>, t: Throwable) {
                Log.d(TAG, "RESPONSE onFailure: "+t.stackTrace+t.localizedMessage)
            }

        })
        return allTaskLists

    }
    fun addTaskList(taskLists: TaskLists){
        retro.addTaskLists(taskLists).enqueue(object :Callback<TaskLists>{
            override fun onResponse(call: Call<TaskLists>, response: Response<TaskLists>) {
                Log.d(TAG, "onResponse: TaskList added successfully"+response.errorBody())
            }

            override fun onFailure(call: Call<TaskLists>, t: Throwable) {
                Log.d(TAG, "onFailure: Cant add TaskList")
            }

        })


    }

    fun addTask(task: Task) {
        retro.addTask(task).enqueue(object :Callback<Task>{
            override fun onResponse(call: Call<Task>, response: Response<Task>) {
                Log.d(TAG, "onResponse: adding Task Successfully completed"+response.body())
            }

            override fun onFailure(call: Call<Task>, t: Throwable) {
                Log.d(TAG, "onFailure: failed to add Task"+t.localizedMessage)
            }

        })
    }
}