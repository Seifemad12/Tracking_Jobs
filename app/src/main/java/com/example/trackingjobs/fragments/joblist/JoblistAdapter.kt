package com.example.trackingjobs.fragments.joblist;

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import com.example.trackingjobs.R
import com.example.trackingjobs.model.UserJobs
import com.example.trackingjobs.model.UserModel


class JoblistAdapter : RecyclerView.Adapter<JoblistAdapter.jobHolder>() {
    private var jobList = ArrayList<UserModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): jobHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.job_item, parent, false)
        return jobHolder(view)
    }

    override fun getItemCount(): Int {
        return jobList.size
    }

    override fun onBindViewHolder(holder: jobHolder, position: Int) {
        holder.Titleitem.text = jobList[position].title
        holder.Body_item.text = jobList[position].body
        holder.itemView.findViewById<RelativeLayout>(R.id.relative).setOnLongClickListener {
            val action = TodoFragmentDirections.actionTodoFragmentToUpdateScreen(jobList[position])
            holder.itemView.findNavController().navigate(action)
            true
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setJobList(list: ArrayList<UserModel>){
        this.jobList = list
        notifyDataSetChanged()
    }

    class jobHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Titleitem = itemView.findViewById<TextView>(R.id.titleItem)
        val Body_item = itemView.findViewById<TextView>(R.id.bodyItem)
    }
}