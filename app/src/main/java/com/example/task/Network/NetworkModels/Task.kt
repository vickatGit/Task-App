package com.example.task.Network.NetworkModels

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.util.*

@Parcelize
data class Task(
    val description: String,

    val dueDate: String,
    val period: String,
    val periodType: String,
    val taskId: Int?,
    val taskName: String,
    val taskList:TaskLists
) : Parcelable