package com.example.task.Fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.lifecycle.Observer
import com.example.task.Network.NetworkModels.TaskLists
import com.example.task.R
import com.example.task.ViewModels.TaskListFragmentViewModel

class TaskListFragment : Fragment() {

    private lateinit var frameLayout: FrameLayout

    companion object {
        fun newInstance() = TaskListFragment()
    }

    private lateinit var viewModel: TaskListFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.task_list_fragment_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TaskListFragmentViewModel::class.java)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frameLayout=view.findViewById(R.id.framelayout)
        viewModel.allTaskLists.observe(this.viewLifecycleOwner, Observer { it:List<TaskLists>? ->

        })

    }



}