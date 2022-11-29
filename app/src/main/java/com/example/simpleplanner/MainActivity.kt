package com.example.simpleplanner

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.simpleplanner.Adapters.RecyclerDayAdapter
import com.example.simpleplanner.Adapters.RecyclerTasksAdapter
import com.example.simpleplanner.Adapters.ViewPagerAdapter
import com.example.simpleplanner.DataClasses.Days
import com.example.simpleplanner.DataClasses.Tasks
import com.example.simpleplanner.Fragments.BothFragment
import com.example.simpleplanner.Fragments.DaysFragment
import com.example.simpleplanner.Fragments.TasksFragment
import com.google.android.material.tabs.TabLayout
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {


    private lateinit var pager: ViewPager // creating object of ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager = findViewById(R.id.viewPager)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(TasksFragment(),"Tasks")
        adapter.addFragment(BothFragment(),"Both")
        adapter.addFragment(DaysFragment(),"Days")


        pager.adapter = adapter
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




}