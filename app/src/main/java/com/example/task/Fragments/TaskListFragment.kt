package com.example.task.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task.Adapters.TaskListAdapter
import com.example.task.AddTaskActivity
import com.example.task.Network.NetworkModels.TaskLists
import com.example.task.R
import com.example.task.ViewModels.TaskListFragmentViewModel

class TaskListFragment : Fragment() {

    private lateinit var frameLayout: FrameLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var taskList: TaskLists
    private lateinit var adapter: TaskListAdapter


    companion object {
        fun newInstance() = TaskListFragment()
        private val TAG="tag"
        public val TASK_LIST_PARSER="task_list_parser"
    }

    private lateinit var viewModel: TaskListFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.task_list_fragment_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle: Bundle? =arguments
        taskList= bundle?.getParcelable<TaskLists>(AllListFragments.TASK_LIST)!!

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView=view.findViewById(R.id.all_tasks)
        recyclerView.setLayoutManager(LinearLayoutManager(this.context))

        adapter=TaskListAdapter(taskList)
        recyclerView.adapter=adapter
        val addTask:ImageView=view.findViewById(R.id.add_task)
        addTask.setOnClickListener {
            val intent: Intent = Intent(view.context, AddTaskActivity::class.java)
            val bundle:Bundle= Bundle()
            bundle.putParcelable(TASK_LIST_PARSER,taskList)
            intent.putExtra(TASK_LIST_PARSER,bundle)
            startActivity(intent)
        }


    }



}