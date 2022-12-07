package com.example.simpleplanner.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ViewSwitcher
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleplanner.DataClasses.Days
import com.example.simpleplanner.DataClasses.Tasks
import com.example.simpleplanner.R


class RecyclerDayAdapter(private var dataSet: List<Days>, var switcher: ViewSwitcher?,
var switchedText: TextView) :
    RecyclerView.Adapter<RecyclerDayAdapter.ViewHolder>(){

    var  tasksList : List<Tasks> ?= null

     var switch: ViewSwitcher? = switcher

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
            switch?.showNext()
        }


        switchedText.setOnClickListener {
            switch?.showNext()
        }

        tasksList = createTasks()
        //holder.rec.setHasFixedSize(true)
        holder.rec.layoutManager = LinearLayoutManager(holder.con)
        holder.rec.adapter = RecyclerTasksAdapter(tasksList!!)

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun createTasks(): List<Tasks>{

        var task1 = Tasks("chuj", "dupa","veri")
        var task2 = Tasks("Rysowanie", "ciała i twarze","veri")
        var task3 = Tasks("Programownie", "android","veri")
        var task4 = Tasks("Praca izny", "nie chce mi sie","veri")
        var task5 = Tasks("Sprzatanie", "ehhh","veri")
        var task6 = Tasks("Gotowanie", "mmmmm","veri")

        val list : List<Tasks> = listOf(task1,task2,task3,task4,task5,task6)

        return list
    }




    //custom viewholder with views in it
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var dateText = view.findViewById<TextView>(R.id.textViewDate)
        var rec : RecyclerView = view.findViewById(R.id.recycler)
        var con: Context = view.context

    }



}