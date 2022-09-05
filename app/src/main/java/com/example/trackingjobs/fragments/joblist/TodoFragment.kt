package com.example.trackingjobs.fragments.joblist

import android.app.ActionBar
import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trackingjobs.R
import com.example.trackingjobs.ViewModel.JobViewModel
import com.example.trackingjobs.databinding.FragmentTodoBinding
import com.example.trackingjobs.model.UserJobs
import com.example.trackingjobs.model.UserModel


class TodoFragment : Fragment() {

    private lateinit var b: FragmentTodoBinding
    lateinit var joblistAdapter: JoblistAdapter
    private lateinit var jobViewModel: JobViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_todo, container, false)
        b = FragmentTodoBinding.bind(view)


        joblistAdapter = JoblistAdapter()
        b.recycle.adapter = joblistAdapter
        b.recycle.layoutManager = LinearLayoutManager(requireContext())

        jobViewModel = ViewModelProvider(this)[JobViewModel::class.java]
        jobViewModel.readAllData.observe(viewLifecycleOwner, Observer { list ->
            joblistAdapter.setJobList(list as ArrayList<UserModel>)
        })


        b.add.setOnClickListener {
            findNavController().navigate(R.id.action_todoFragment_to_addScreen)
        }
        return view
    }

    /*private fun buildAlertDialog() {
        val builder = AlertDialog.Builder(requireContext())
        val dialogLayout =layoutInflater.inflate(R.layout.add_layout,null)
        val addText =dialogLayout.findViewById<TextView>(R.id.toAdd)

        with(builder){
            setTitle("Enter your next job")
            setPositiveButton("Add"){_,_ ->
                val userJob = UserJobs(0, getCurrent().id,addText.text.toString())
                jobViewModel.addUserJob(userJob)
            }
            setNegativeButton("Cancel"){_,_ ->}
        }
        builder.setView(dialogLayout)
        builder.show()
    }*/
}