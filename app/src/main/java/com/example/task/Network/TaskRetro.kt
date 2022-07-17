package com.example.task.Network

import com.example.task.Network.NetworkModels.TaskLists
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TaskRetro {
    @GET("/getTaskLists")
    fun getTaskLists():Response<List<TaskLists>>
}