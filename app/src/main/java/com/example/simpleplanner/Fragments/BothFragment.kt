package com.example.simpleplanner.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ViewSwitcher
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleplanner.Adapters.RecyclerDayAdapter
import com.example.simpleplanner.Adapters.RecyclerTasksAdapter
import com.example.simpleplanner.DataClasses.Days
import com.example.simpleplanner.DataClasses.Tasks
import com.example.simpleplanner.R
import java.text.SimpleDateFormat


class BothFragment : Fragment() {

    var  daysList : List<Days> ?= null
    var  tasksList : List<Tasks> ?= null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        inflater.inflate(R.layout.fragment_both, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recDays = view.findViewById<RecyclerView>(R.id.RecyclerViewDaysBoth)
        val recTasks = view.findViewById<RecyclerView>(R.id.RecyclerViewTasksBoth)

        //creates list for using in recyclers
        daysList = createDays()
        tasksList = createTasks()

        //configures recyclers, theirs adapters and layout managers
        recDays.adapter = RecyclerDayAdapter(daysList!!)
        recDays.layoutManager = LinearLayoutManager(context)


        recTasks.adapter = RecyclerTasksAdapter(tasksList!!)
        recTasks.layoutManager = LinearLayoutManager(context)

        setupViewSwitcher()
    }

    fun createDays(): List<Days> {
        val formatter = SimpleDateFormat("dd-MM-yyyy")

        var date1 = "01-01-2000"
        var date2 = "03-05-2000"
        var date3 = "07-06-2000"
        var date4 = "18-07-2000"
        var date5 = "26-07-2000"


        var day1 = Days(formatter.parse(date1))
        var day2 = Days(formatter.parse(date2))
        var day3 = Days(formatter.parse(date3))
        var day4 = Days(formatter.parse(date4))
        var day5 = Days(formatter.parse(date5))

        val list : List<Days> = listOf(day1,day2,day3,day4,day5)

        return list
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

    private fun setupViewSwitcher() {
        val viewSwitcher = view?.findViewById<ViewSwitcher>(R.id.viewSwitcher)
        val inAnim = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)
        if (viewSwitcher != null) {
            viewSwitcher.inAnimation = inAnim
        }

        val out = AnimationUtils.loadAnimation(context, android.R.anim.slide_out_right)
        if (viewSwitcher != null) {
            viewSwitcher.outAnimation = out
        }


    }


}