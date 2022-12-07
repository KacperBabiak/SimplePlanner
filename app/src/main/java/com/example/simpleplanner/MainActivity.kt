package com.example.simpleplanner

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.Toast
import android.widget.ViewSwitcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleplanner.Adapters.RecyclerDayAdapter
import com.example.simpleplanner.Adapters.RecyclerTasksAdapter
import com.example.simpleplanner.DataClasses.Days
import com.example.simpleplanner.DataClasses.Tasks
import com.google.android.material.chip.Chip
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {

    var  daysList : List<Days> ?= null
    var  tasksList : List<Tasks> ?= null

    lateinit var recDays :RecyclerView
    lateinit var recTasks :RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureRecyclers()
        setupViewSwitcher()
        configureChips()
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Calendar -> {
                Toast.makeText(applicationContext, "calendar", Toast.LENGTH_LONG).show()
                true
            }
            R.id.Notes ->{
                Toast.makeText(applicationContext, "notes", Toast.LENGTH_LONG).show()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
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
        val viewSwitcher = findViewById<ViewSwitcher>(R.id.viewSwitcher)
        val inAnim = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        if (viewSwitcher != null) {
            viewSwitcher.inAnimation = inAnim
        }

        val out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right)
        if (viewSwitcher != null) {
            viewSwitcher.outAnimation = out
        }


    }

    private fun configureRecyclers(){
         recDays = findViewById<RecyclerView>(R.id.RecyclerViewDays)
         recTasks = findViewById<RecyclerView>(R.id.RecyclerViewTasks)

        //creates list for using in recyclers
        daysList = createDays()
        tasksList = createTasks()

        //configures recyclers, theirs adapters and layout managers
        recDays.adapter = RecyclerDayAdapter(daysList!!,findViewById(R.id.viewSwitcher),
        findViewById(R.id.textSwitched))
        recDays.layoutManager = LinearLayoutManager(this)


        recTasks.adapter = RecyclerTasksAdapter(tasksList!!)
        recTasks.layoutManager = LinearLayoutManager(this)
    }

    private fun configureChips(){
        val chipTasks: Chip = findViewById(R.id.chipTask)
        val chipDays: Chip = findViewById(R.id.chipDays)

        chipDays.setOnClickListener{
            if(recDays.visibility==View.VISIBLE){
                recDays.visibility=View.GONE
            }
            else{
                recDays.visibility=View.VISIBLE
            }
        }

        chipTasks.setOnClickListener{
            if(recTasks.visibility==View.VISIBLE){
                recTasks.visibility=View.GONE


            }
            else{
                recTasks.visibility=View.VISIBLE

            }
        }
    }





}