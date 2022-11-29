package com.example.simpleplanner.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleplanner.DataClasses.Days
import com.example.simpleplanner.DataClasses.Tasks
import com.example.simpleplanner.R

class RecyclerDayAdapter (private var dataSet: List<Days>) :
    RecyclerView.Adapter<RecyclerDayAdapter.ViewHolder>(){

    //creates and inflates view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.day,parent,false)
        return ViewHolder(view)
    }

    //binds data to text inside
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dateText.text = dataSet[position].date.toString()

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }




    //custom viewholder with views in it
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var dateText = view.findViewById<TextView>(R.id.textViewDate)

    }


}