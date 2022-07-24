package com.example.task

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task.Adapters.TaskListAdapter
import com.example.task.Fragments.AllListFragments
import com.example.task.Network.NetworkModels.TaskLists

class TaskListViewerActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    companion object{
        private val TAG:String="tag"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list_viewer)

        recyclerView=findViewById(R.id.task_list_viewer)
        recyclerView.layoutManager=LinearLayoutManager(this)
        val bundle: Bundle? =intent.getBundleExtra(AllListFragments.TASK_LIST_CONTAINER)
//         bundle?.getParcelable<TaskLists>(AllListFragments.TASK_LIST)

        if(bundle!=null){
            val taskList: TaskLists? =bundle.getParcelable<TaskLists>(AllListFragments.TASK_LIST_CONTAINER)
            Log.d(TAG, "onCreate: in TaskListViewerActivity "+taskList?.toString())
            val taskAdapter:TaskListAdapter= TaskListAdapter(taskList!!)
            recyclerView.adapter=taskAdapter
        }

    }

}