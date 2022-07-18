package com.example.task.Fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task.Adapters.TaskListAdapter
import com.example.task.Network.NetworkModels.TaskLists
import com.example.task.R
import com.example.task.ViewModels.TaskListFragmentViewModel

class TaskListFragment : Fragment() {

    private lateinit var frameLayout: FrameLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var taskLists:MutableList<TaskLists>
    private lateinit var adapter:TaskListAdapter

    companion object {
        fun newInstance() = TaskListFragment()
        private val TAG="tag"
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
        viewModel.getTaskLists().observe(this.viewLifecycleOwner, Observer { it:List<TaskLists>? ->
            taskLists.clear()
            taskLists.addAll(it!!)
//            Log.d(TAG, "onActivityCreated: "+taskLists.get(0).tasks.get(0).taskName)
            adapter.notifyDataSetChanged()
            Log.d("TAG",it.get(0).name)
        })
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        taskLists= ArrayList<TaskLists>()
        recyclerView=view.findViewById(R.id.all_tasks)
        recyclerView.setLayoutManager(LinearLayoutManager(this.context))
        adapter=TaskListAdapter(taskLists)
        recyclerView.adapter=adapter






    }



}