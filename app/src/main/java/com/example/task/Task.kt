package com.example.task

data class Task(
    val description: String,
    val dueDate: Any,
    val period: String,
    val periodType: String,
    val taskId: Int,
    val taskName: String
)