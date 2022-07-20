package com.example.task.Network.NetworkModels

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Task(
    val description: String,

    val dueDate: @RawValue Any,
    val period: String,
    val periodType: String,
    val taskId: Int,
    val taskName: String
) : Parcelable