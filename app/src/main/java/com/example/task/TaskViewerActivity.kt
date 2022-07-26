package com.example.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.task.Adapters.TaskListAdapter
import com.example.task.Network.NetworkModels.Task
import com.example.task.ViewModels.TaskViewerActivityViewModel
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

class TaskViewerActivity : AppCompatActivity() {

    private lateinit var taskName:TextView
    private lateinit var description:TextView
    private lateinit var date:TextView
    private lateinit var period:TextView
    private lateinit var remainingPeriod:TextView
    private lateinit var deleteTask: Button
    private lateinit var taskViewerViewModel:TaskViewerActivityViewModel

    companion object{
        private val TAG="tag"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_viewer)
        taskViewerViewModel=ViewModelProvider(this).get(TaskViewerActivityViewModel::class.java)

        taskName=findViewById(R.id.task_name)
        description=findViewById(R.id.task_description)
        date=findViewById(R.id.date)
        period=findViewById(R.id.period)
        remainingPeriod=findViewById(R.id.remaining_period)
        deleteTask=findViewById(R.id.delete_task)






        var bundle:Bundle= intent.getBundleExtra(TaskListAdapter.TASK_PARSER)!!
        val task: Task? =bundle.getParcelable<Task>(TaskListAdapter.TASK_PARSER)

        taskName.setText(task?.taskName)
        description.setText(task?.description)

        date.setText(SimpleDateFormat("dd/MM/yy").format(Date(task?.dueDate)))
        period.setText("Total Period : "+task?.period)
        remainingPeriod.setText("Remaining Period : "+((Date(task?.dueDate).time/(24*60*60*1000))- Date().time/(24*60*60*1000)))
        Log.d(TAG, "onCreate: days"+(Date(task?.dueDate).time/(24*60*60*1000)))

        deleteTask.setOnClickListener {
            taskViewerViewModel.delteTask(task?.taskId!!)
        }
    }
}