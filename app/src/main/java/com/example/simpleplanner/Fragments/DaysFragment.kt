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
import com.example.simpleplanner.DataClasses.Days
import com.example.simpleplanner.R
import java.text.SimpleDateFormat

class DaysFragment : Fragment() {

    var  daysList : List<Days> ?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        inflater.inflate(R.layout.fragment_days, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recDays = view.findViewById<RecyclerView>(R.id.RecyclerViewDaysOnly)


        //creates list for using in recyclers
        daysList = createDays()


        //configures recyclers, theirs adapters and layout managers
        recDays.adapter = RecyclerDayAdapter(daysList!!)
        recDays.layoutManager = LinearLayoutManager(context)


    }

    fun createDays(): List<Days> {
        val formatter = SimpleDateFormat("dd-MM-yyyy")

        var date1 = "01-01-2000"
        var date2 = "03-05-2000"
        var date3 = "07-06-2000"
        var date4 = "18-07-2000"
        var date5 = "26-07-2000"
        var date6 = "26-07-2000"
        var date7 = "26-07-2000"


        var day1 = Days(formatter.parse(date1))
        var day2 = Days(formatter.parse(date2))
        var day3 = Days(formatter.parse(date3))
        var day4 = Days(formatter.parse(date4))
        var day5 = Days(formatter.parse(date5))
        var day6 = Days(formatter.parse(date6))
        var day7 = Days(formatter.parse(date7))

        val list : List<Days> = listOf(day1,day2,day3,day4,day5,day6,day7)

        return list
    }

}