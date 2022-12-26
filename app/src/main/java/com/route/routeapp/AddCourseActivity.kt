package com.route.routeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

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
        addCourseButton.setOnClickListener(object : OnClickListener {
            override fun onClick(p0: View?) {
                val title: String = titleEditText.text.toString()//""
                val content: String = contentEditText.text.toString()//""
                if (title.isNotEmpty() && content.isNotEmpty()) {
                    val intent1 = Intent()
                    intent1.putExtra(Constants.EXTRA_TITLE, title)
                    intent1.putExtra(Constants.EXTRA_CONTENT, content)
                    setResult(RESULT_OK, intent1)
                    finish()
                }else{
                    Toast.makeText(this@AddCourseActivity, "Please Enter Course Title And Content ", Toast.LENGTH_LONG).show()

                }

            }


        })
    }
}