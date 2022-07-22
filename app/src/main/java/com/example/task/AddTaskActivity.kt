package com.example.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.util.Pair
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.example.task.Fragments.TaskListFragment
import com.example.task.Network.NetworkModels.Task
import com.example.task.Network.NetworkModels.TaskLists
import com.example.task.ViewModels.AddTaskViewModel
import com.example.task.ViewModels.TaskListFragmentViewModel
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.CompositeDateValidator
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.Gson
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class AddTaskActivity : AppCompatActivity() {

    private lateinit var dueDateContainer:TextInputLayout
    private lateinit var dueDate:EditText
    private lateinit var descriptionContainer:TextInputLayout
    private lateinit var description:EditText
    private lateinit var taskNameContainer:TextInputLayout
    private lateinit var taskName:EditText
    private lateinit var addTask:Button
    private var dueDateMillies: Long = 0
    private var period:Long=0
    private var periodType:String=""
    private lateinit var addTaskViewModel:AddTaskViewModel

    companion object{
        private val DUE_DATE_SELECTOR="due_date_selector"
        private val TAG="tag"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addTaskViewModel=ViewModelProvider(this).get(AddTaskViewModel::class.java)

        val bundle: Bundle? =intent.getBundleExtra(TaskListFragment.TASK_LIST_PARSER)
        val taskList: TaskLists? =bundle?.getParcelable<TaskLists>(TaskListFragment.TASK_LIST_PARSER)


        setContentView(R.layout.activity_add_task)
        dueDateContainer=findViewById(R.id.due_date_container)
        dueDate=findViewById(R.id.due_date)
        taskNameContainer=findViewById(R.id.title_container)
        taskName=findViewById(R.id.title)
        descriptionContainer=findViewById(R.id.description_container)
        description=findViewById(R.id.description)


        addTask=findViewById(R.id.add_task)


//        val constraints=CalendarConstraints.Builder()
//
//        val Calendar:CalendarConstraints.DateValidator?=dateValidator()
//        constraints.setValidator(Calendar!!)


        val dateBuilder= MaterialDatePicker.Builder.dateRangePicker()
            .setTitleText("Due Date")
            .setSelection(Pair(MaterialDatePicker.thisMonthInUtcMilliseconds(),MaterialDatePicker.todayInUtcMilliseconds())).build()

        dueDate.setOnFocusChangeListener(object :View.OnFocusChangeListener{
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if(dueDate.isFocused) {
                    dateBuilder.show(supportFragmentManager, DUE_DATE_SELECTOR)
                    dateBuilder.addOnPositiveButtonClickListener {
                        val date: String = SimpleDateFormat("dd/MM/yyyy").format(Date(it.second))
                        dueDate.setText(date)
                        period=it.second-it.first
                        period=period/1000/60/60/24
                        if(period>30)
                            periodType="monthly"
                        else if(period>365)
                            periodType="yearly"
                        else
                            periodType="daily"


                        dueDateMillies = it.second
                    }
                }
            }

        })

        addTask.setOnClickListener{
            val date=Date(dueDateMillies)
            val Format: DateFormat =SimpleDateFormat("dd MMM yyyy HH:mm:ss zzz")


//            val ow: ObjectWriter = ObjectMapper().writer().withDefaultPrettyPrinter()
//            val json: String = ow.writeValueAsString(taskList)
            val gson:Gson= Gson()


//            var taskParent: TaskLists=TaskLists()
//            taskParent.list_id=taskList?.list_id
            Log.d(TAG, "onCreate: "+Format.format(date))
            val task:Task= Task(description.text.toString(),Format.format(date),period.toString(),periodType,null,taskName.text.toString(),taskList!!)
            Log.d(TAG, "onCreate:------------- "+gson.toJson(task))
            addTaskViewModel.addTask(task)
        }

    }

}
@Parcelize
class dateValidator:CalendarConstraints.DateValidator{
    override fun isValid(date: Long): Boolean = date>=System.currentTimeMillis()
}