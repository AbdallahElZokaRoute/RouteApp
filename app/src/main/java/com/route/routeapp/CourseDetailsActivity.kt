package com.route.routeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class CourseDetailsActivity : AppCompatActivity() {
    var content: String? = null
    var title: String? = null
    var image: Int? = null
    lateinit var courseImage: ImageView
    lateinit var contentTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details)
        title = intent.getStringExtra(Constants.EXTRA_TITLE)
        content = intent.getStringExtra(Constants.EXTRA_CONTENT)
        contentTextView = findViewById(R.id.course_content)
        contentTextView.text = content
        image = intent.getIntExtra(Constants.EXTRA_IMAGE, R.drawable.splash_screen)
        courseImage = findViewById(R.id.image_course)
        courseImage.setImageResource(image ?: R.drawable.splash_screen)
    }
}