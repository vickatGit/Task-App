package com.example.task.Fragments

import android.content.res.Resources
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.task.Adapters.TaskListAdapter
import com.example.task.Network.NetworkModels.TaskLists
import com.example.task.R
import com.example.task.ViewModels.TaskListFragmentViewModel
import kotlin.math.log

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AllListFragments : Fragment() {

    private lateinit var viewModel: TaskListFragmentViewModel
    private lateinit var taskLists:ArrayList<TaskLists>
    private lateinit var adapter: TaskListAdapter
    private lateinit var frameLayout_container:LinearLayout

    companion object {
        public val TAG="tag"
        public val TASK_LIST="task_list"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    private fun refreshDataSet(taskLists: MutableList<TaskLists>) {

        val fragments_container:LinearLayout=LinearLayout(this.context)
        fragments_container.layoutParams=ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)

        for (taskList in taskLists){


            val taskListFrameLayout:FrameLayout=FrameLayout(this.requireContext())//requireContext return non-null context
            taskListFrameLayout.layoutParams= ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
            val taskListFragment:Fragment=TaskListFragment()
            val bundle:Bundle= Bundle()
            
            bundle.putParcelable(TASK_LIST,taskList)
            taskListFragment.arguments=bundle
            taskListFrameLayout.id=View.generateViewId()
            childFragmentManager.beginTransaction().replace(taskListFrameLayout.id,taskListFragment).commit()
//            fragments_container.removeAllViews()
            fragments_container.addView(taskListFrameLayout)


        }
//        frameLayout_container.removeAllViews()
        Log.d(TAG, "refreshDataSet: ")
        frameLayout_container.addView(fragments_container)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_list_fragments, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        taskLists= ArrayList<TaskLists>()
        frameLayout_container=view.findViewById(R.id.fragment_container)
        viewModel=ViewModelProvider(this).get(TaskListFragmentViewModel::class.java)
        viewModel.getTaskLists().observe(this.viewLifecycleOwner, Observer { it:List<TaskLists>? ->
            taskLists.clear()
            taskLists.addAll(it!!)

            refreshDataSet(taskLists)
        })

    }
}