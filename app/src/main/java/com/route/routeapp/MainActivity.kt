package com.route.routeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var coursesRecyclerView: RecyclerView
    lateinit var adapter: CoursesAdapter
    lateinit var addButton: FloatingActionButton
    lateinit var coursesList: ArrayList<CourseDataItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        coursesRecyclerView = findViewById(R.id.courses_recycler_view)
        adapter = CoursesAdapter(null)
        coursesRecyclerView.adapter = adapter
        adapter.onCourseClickListener = object : OnCourseClickListener {
            override fun onCourseClick(itemClicked: CourseDataItem) {
                val intent = Intent(this@MainActivity, CourseDetailsActivity::class.java)
                intent.putExtra(Constants.EXTRA_TITLE, itemClicked.courseTitle)
                intent.putExtra(Constants.EXTRA_CONTENT, itemClicked.courseContent)
                intent.putExtra(Constants.EXTRA_IMAGE, itemClicked.courseImage)
                startActivity(intent)
            }

        }
        initData()
        addButton = findViewById(R.id.add_fab)
        addButton.setOnClickListener(object : OnClickListener {
            override fun onClick(p0: View?) {
                val intent = Intent(this@MainActivity, AddCourseActivity::class.java)
                startActivity(intent)
            }
        })

    }

    fun initData() {
        coursesList = ArrayList<CourseDataItem>()
        coursesList.add(
            CourseDataItem(
                "Android Course", R.drawable.android_image,
                Constants.androidContent
            )
        )
        coursesList.add(
            CourseDataItem(
                "Fullstack Course", R.drawable.full_stack_image, Constants.fullStackContent
            )
        )
        coursesList.add(CourseDataItem("IOS Course", R.drawable.ios_image, Constants.iosContent))
        adapter.setData(coursesList)
    }
}