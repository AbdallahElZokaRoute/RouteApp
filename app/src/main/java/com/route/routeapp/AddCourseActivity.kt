package com.route.routeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText

class AddCourseActivity : AppCompatActivity() {
    lateinit var titleEditText: EditText
    lateinit var contentEditText: EditText
    lateinit var addCourseButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_course)
        initViews()
    }

    fun initViews() {
        titleEditText = findViewById(R.id.course_title_edit_Text)
        contentEditText = findViewById(R.id.course_content_edit_Text)
        addCourseButton = findViewById(R.id.add_course_button)
        addCourseButton.setOnClickListener(object : OnClickListener{
            override fun onClick(p0: View?) {

            }


        })
    }
}