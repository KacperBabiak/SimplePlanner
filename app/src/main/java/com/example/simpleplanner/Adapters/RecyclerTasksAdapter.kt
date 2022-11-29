package com.example.simpleplanner.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleplanner.DataClasses.Tasks
import com.example.simpleplanner.R

class RecyclerTasksAdapter(private val dataSet: List<Tasks>) :
    RecyclerView.Adapter<RecyclerTasksAdapter.ViewHolder>(){

    //creates and inflates view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).
                inflate(R.layout.task,parent,false)
        return ViewHolder(view)
    }

    //binds data to text inside
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleText.text = dataSet[position].title
        holder.descText.text = dataSet[position].description
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


    //custom viewholder with views in it
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var titleText = view.findViewById<TextView>(R.id.textViewTitle)
        var descText = view.findViewById<TextView>(R.id.textViewDescription)
    }



}