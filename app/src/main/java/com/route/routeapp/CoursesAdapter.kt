package com.route.routeapp

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder


/*
List is Parent of Array List
   ArrayList

   fun changeData(data : List<CourseDataItem>){
        this.coursesList = data
   }

 */
class CoursesAdapter(
    var coursesList: List<CourseDataItem>?
) : Adapter<CoursesAdapter.CoursesViewHolder>() {

    var onCourseClickListener: OnCourseClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_list_item_layout, parent, false)
        return CoursesViewHolder(view)
    }

    fun updateData(courses: List<CourseDataItem>) {
        this.coursesList = courses
        notifyDataSetChanged() //Refresh Data

    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        val courseItem = coursesList?.get(position)!!
        holder.courseButton.text = courseItem.courseTitle
        holder.courseImage.setImageResource(
            courseItem.courseImage
        )
        holder.itemView.setOnClickListener(object : OnClickListener {
            override fun onClick(p0: View?) {
                onCourseClickListener?.onCourseClick(courseItem)
            }

        })
    }

    override fun getItemCount(): Int {
        return coursesList?.size ?: 0
    }


    class CoursesViewHolder(itemView: View) : ViewHolder(itemView) {
        val courseButton: Button
        val courseImage: ImageView

        init {
            courseButton = itemView.findViewById(R.id.course_button)
            courseImage = itemView.findViewById(R.id.course_image)
        }
    }
}