package com.example.task

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task.Adapters.TaskListAdapter
import com.example.task.Fragments.AllListFragments
import com.example.task.Network.NetworkModels.TaskLists
import java.text.SimpleDateFormat

class TaskListViewerActivity : AppCompatActivity() {

    private lateinit var recyclerView:RecyclerView
    private lateinit var taskListName:TextView
    lateinit var context: Context
    companion object{
        private val TAG:String="tag"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list_viewer)
        context=this

        recyclerView=findViewById(R.id.task_list_viewer)
        taskListName=findViewById(R.id.task_list_name)
        recyclerView.layoutManager=LinearLayoutManager(this)
        val bundle: Bundle? =intent.getBundleExtra(AllListFragments.TASK_LIST_CONTAINER)



        if(bundle!=null){
            val taskList: TaskLists? =bundle.getParcelable<TaskLists>(AllListFragments.TASK_LIST_CONTAINER)
            taskListName.setText(taskList?.name)
            Log.d(TAG, "onCreate: in TaskListViewerActivity "+taskList?.toString())
            val taskAdapter:TaskListAdapter= TaskListAdapter(taskList!!,context)
            recyclerView.adapter=taskAdapter
        }

    }

}