package com.route.routeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
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
        adapter.updateData(coursesList)
    }

    override fun onStart() {
        super.onStart()

        val activityResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback<ActivityResult> {
                //it.data // Holds Data of Second Activity
                //it.resultCode // Check On Result Code
                if (it.resultCode == RESULT_OK) {
                    val intent1 = it.data
                    val title = intent1?.getStringExtra(Constants.EXTRA_TITLE)
                    val content = intent1?.getStringExtra(Constants.EXTRA_CONTENT)
                    Log.e("TAG", "onStart: $title")
                    Log.e("TAG", "onStart: $content")
                    coursesList.add(
                        CourseDataItem(
                            courseTitle = title!!,
                            courseImage = R.drawable.android_image,
                            courseContent = content!!
                        )
                    )
                    adapter.updateData(coursesList)

                }
            })
        addButton.setOnClickListener(object : OnClickListener {
            override fun onClick(p0: View?) {
                val intent = Intent(this@MainActivity, AddCourseActivity::class.java)
                //startActivity(intent)
                activityResult.launch(intent)
                //startActivityForResult()

            }
        })
        //start Activity for Result ->
        //Activity 1 -> startActivity for result
        //Activity 2 -> setResult ->
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
    }
}