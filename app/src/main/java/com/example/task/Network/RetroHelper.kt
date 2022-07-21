package com.example.task.Network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetroHelper {

    fun getInstance():Retrofit{
        val okhttp:OkHttpClient=OkHttpClient.Builder().readTimeout(60,TimeUnit.SECONDS).build()
        return Retrofit.Builder().baseUrl("http://192.168.43.103:8080/TaskLists/")
            .client(okhttp)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

}