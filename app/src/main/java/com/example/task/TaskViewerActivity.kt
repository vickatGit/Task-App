package com.example.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.task.Adapters.TaskListAdapter
import com.example.task.Network.NetworkModels.Task

class TaskViewerActivity : AppCompatActivity() {

    private lateinit var taskName:TextView
    private lateinit var description:TextView
    private lateinit var date:TextView
    private lateinit var period:TextView
    private lateinit var remainingPeriod:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_viewer)

        taskName=findViewById(R.id.task_name)
        description=findViewById(R.id.task_description)
        date=findViewById(R.id.date)
        period=findViewById(R.id.period)
        remainingPeriod=findViewById(R.id.remaining_period)
        var bundle:Bundle= intent.getBundleExtra(TaskListAdapter.TASK_PARSER)!!
        val task: Task? =bundle.getParcelable<Task>(TaskListAdapter.TASK_PARSER)
        taskName.setText(task?.taskName)
        description.setText(task?.description)
        date.setText(task?.dueDate)
        period.setText(task?.period)
        remainingPeriod.setText(task?.periodType)
    }
}