package com.example.simpleplanner.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleplanner.DataClasses.Days
import com.example.simpleplanner.DataClasses.Tasks
import com.example.simpleplanner.MainActivity
import com.example.simpleplanner.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.currentCoroutineContext

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

        holder.dateText.setOnClickListener {





        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }




    //custom viewholder with views in it
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var dateText = view.findViewById<TextView>(R.id.textViewDate)
        var linear : LinearLayout = view.findViewById(R.id.linear)
    }


}