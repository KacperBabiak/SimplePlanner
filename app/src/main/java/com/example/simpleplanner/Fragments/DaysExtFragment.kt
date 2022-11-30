package com.example.simpleplanner.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleplanner.Adapters.RecyclerDayAdapter
import com.example.simpleplanner.Adapters.RecyclerTasksAdapter
import com.example.simpleplanner.DataClasses.Tasks
import com.example.simpleplanner.R

class DaysExtFragment : Fragment() {

    var  tasksList : List<Tasks> ?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        inflater.inflate(R.layout.day_extended, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recTasks = view.findViewById<RecyclerView>(R.id.recycler_ext)

        //creates list for using in recyclers

        tasksList = createTasks()

        //configures recyclers, theirs adapters and layout managers


        recTasks.adapter = RecyclerTasksAdapter(tasksList!!)
        recTasks.layoutManager = LinearLayoutManager(context)
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

}