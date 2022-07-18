package com.example.task.Network.NetworkModels

data class TaskLists(
    val active: Boolean,
    val description: String,
    val list_id: Int,
    val name: String,
    val tasks: List<Task>

)