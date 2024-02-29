package com.mindhive.studentlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: StudentAdapter
    private lateinit var students: ArrayList<StudentList>
    lateinit var jsonString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvStudent = findViewById<RecyclerView>(R.id.rvStudentList)
        rvStudent.layoutManager = LinearLayoutManager(this)


        try {
            jsonString = this.applicationContext.assets.open("studentData/students.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (_: IOException) {
        }

        val listStudents = object : TypeToken<List<StudentList>>() {}.type
        students = Gson().fromJson(jsonString, listStudents)

        adapter = StudentAdapter(students)
        rvStudent.adapter = adapter

    }

}