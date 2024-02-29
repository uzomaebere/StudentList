package com.mindhive.studentlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class StudentAdapter(private val studentList: ArrayList<StudentList>) :
    RecyclerView.Adapter<StudentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return if (viewType == R.layout.student_layout){
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.student_layout, parent, false)
            StudentViewHolder(view)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.student_right_layout, parent, false)
            StudentViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val studentInfo = studentList[position]
        holder.bindUI(studentInfo)

    }

    override fun getItemCount(): Int {
        return studentList.count()
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) R.layout.student_layout else R.layout.student_right_layout
    }
}

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val image = itemView.findViewById<ImageView>(R.id.imageView)
    private val txtName = itemView.findViewById<TextView>(R.id.txtName)
    private val txtAge = itemView.findViewById<TextView>(R.id.txtAge)
    private val txtCourse = itemView.findViewById<TextView>(R.id.txtCourse)
    private val txtRegNo = itemView.findViewById<TextView>(R.id.txtRegNo)


    fun bindUI(studentInfo: StudentList) {
        txtName.text = studentInfo.name
        txtCourse.text = studentInfo.department
        txtAge.text = studentInfo.age.toString()
        txtRegNo.text = studentInfo.id

        Glide.with(itemView.context)
            .load(studentInfo.avatar)
            .into(image)
    }
}
