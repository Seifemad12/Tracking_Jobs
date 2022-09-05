package com.example.trackingjobs.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.trackingjobs.R
import com.example.trackingjobs.ViewModel.JobViewModel
import com.example.trackingjobs.databinding.FragmentUpdateScreenBinding
import com.example.trackingjobs.model.UserModel

class UpdateScreen : Fragment() {
    lateinit var b: FragmentUpdateScreenBinding
    private val args by navArgs<UpdateScreenArgs>()
    private lateinit var jobViewModel: JobViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update_screen, container, false)
        b = FragmentUpdateScreenBinding.bind(view)

        setHasOptionsMenu(true)

        jobViewModel = ViewModelProvider(this)[JobViewModel::class.java]
        b.title.setText(args.currentNote.title)
        b.body.setText(args.currentNote.body)

        b.updatebutton.setOnClickListener {
            val user =
                UserModel(args.currentNote.id, b.title.text.toString(), b.body.text.toString())
            jobViewModel.updateUser(user)
            findNavController().navigate(R.id.action_updateScreen_to_todoFragment)
        }
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.delicon -> {
                deleteJob()
            }
        }
        return true
    }

    private fun deleteJob() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_,->
            jobViewModel.deleteUser(args.currentNote)
            findNavController().navigate(R.id.action_updateScreen_to_todoFragment)
            Toast.makeText(requireContext(),"Successfully Deleted", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No"){_,_ ->
        }
        builder.setTitle("Delete Specific job")
        builder.setMessage("Are you sure you want to delete this job?")
        builder.create().show()
    }

}