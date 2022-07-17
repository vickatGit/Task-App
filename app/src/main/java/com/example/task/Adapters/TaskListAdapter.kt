package com.example.task.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task.Network.NetworkModels.TaskLists
import com.example.task.R

class TaskListAdapter(val taskLists:List<TaskLists>) : RecyclerView.Adapter<thisViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): thisViewHolder {
        val layoutInflater:LayoutInflater= LayoutInflater.from(parent.context)
        val view:View=layoutInflater.inflate(R.layout.task_item_layout,parent,false)
        return thisViewHolder(view)

    }

    override fun onBindViewHolder(holder: thisViewHolder, position: Int) {
        val currentTaskLists:TaskLists=taskLists.get(position)

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}
class thisViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val checkBox:CheckBox=itemView.findViewById(R.id.checkBox)
    val Task:TextView=itemView.findViewById(R.id.task)

}