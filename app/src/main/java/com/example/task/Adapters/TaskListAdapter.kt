package com.example.task.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task.Network.NetworkModels.Task
import com.example.task.Network.NetworkModels.TaskLists
import com.example.task.R

class TaskListAdapter(val taskLists: TaskLists) : RecyclerView.Adapter<thisViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): thisViewHolder {
        val layoutInflater:LayoutInflater= LayoutInflater.from(parent.context)
        val view:View=layoutInflater.inflate(R.layout.task_item_layout,parent,false)
        return thisViewHolder(view)

    }
    companion object{
        private val TAG="tag"
    }

    override fun onBindViewHolder(holder: thisViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: ")
        if(taskLists!=null) {
            if(taskLists.tasks!!.size>0) {
                val currentTask: Task = taskLists.tasks.get(position)

                    holder.Task.setText(currentTask.taskName)
                    Log.d(TAG, "onBindViewHolder: "+currentTask.taskName)
            }
        }

    }

    override fun getItemCount(): Int {

        if(taskLists!=null) {
            return taskLists.tasks!!.size
        }
        else
            return 0
    }

}
class thisViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val checkBox:CheckBox=itemView.findViewById(R.id.checkBox)
    val Task:TextView=itemView.findViewById(R.id.task)

}