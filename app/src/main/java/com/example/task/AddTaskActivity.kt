package com.example.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker

class AddTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val constraints=CalendarConstraints.Builder

        val dateBuilder = MaterialDatePicker.Builder.dateRangePicker()
            .setTitleText("Due Date")
            .setCalendarConstraints()

    }
}