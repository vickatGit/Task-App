package com.example.task.Network.NetworkModels

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Nullable
import kotlinx.android.parcel.Parcelize
import java.lang.reflect.Constructor

@Parcelize
data class TaskLists(
    val active: Boolean,
    val description: String,
    @Nullable
    var list_id: Int?,
    val name: String,
    @Nullable
    val tasks: List<Task>?

//    constructor(val active:Boolean,val description:String,val name:String,val tasks: List<Task>)

) : Parcelable