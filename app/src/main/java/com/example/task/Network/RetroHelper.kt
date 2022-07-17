package com.example.task.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroHelper {

    fun getInstance():Retrofit{
        return Retrofit.Builder().baseUrl("http://localhost:8080/TaskLists")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

}