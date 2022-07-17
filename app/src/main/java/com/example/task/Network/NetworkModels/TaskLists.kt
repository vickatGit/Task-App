package com.example.task.Network.NetworkModels

import com.example.task.Task

data class TaskLists(
    val active: Boolean,
    val description: String,
    val list_id: Int,
    val name: String,
    val tasks: List<Task>

)