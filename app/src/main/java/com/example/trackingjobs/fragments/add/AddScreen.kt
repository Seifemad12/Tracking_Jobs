package com.example.trackingjobs.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.trackingjobs.R
import com.example.trackingjobs.ViewModel.JobViewModel
import com.example.trackingjobs.databinding.FragmentAddScreenBinding
import com.example.trackingjobs.fragments.joblist.TodoFragmentArgs
import com.example.trackingjobs.model.UserJobs
import com.example.trackingjobs.model.UserModel

class AddScreen : Fragment() {
    lateinit var b: FragmentAddScreenBinding
    private lateinit var jobViewModel: JobViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_screen, container, false)
        b = FragmentAddScreenBinding.bind(view)


        jobViewModel = ViewModelProvider(this)[JobViewModel::class.java]
        b.addbutton.setOnClickListener {
            val user = UserModel(0,b.title.text.toString(),b.body.text.toString())
            jobViewModel.addUser(user)
            findNavController().navigate(R.id.action_addScreen_to_todoFragment)
        }
        return view
    }
}