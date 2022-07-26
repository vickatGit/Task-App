package com.example.task.Network

import com.example.task.Network.NetworkModels.Task
import com.example.task.Network.NetworkModels.TaskLists
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TaskRetro {
    @GET("getTaskLists")
    fun getTaskLists():Call<List<TaskLists>>

    @POST("addTaskList")
    fun addTaskLists(@Body taskLists: TaskLists):Call<TaskLists>

    @POST("addTask")
    fun addTask(@Body task: Task):Call<Task>

    @GET("deleteTask/{task_id}")
    fun deleteTask(@Path("task_id") task_id : Int):Call<Void>
}