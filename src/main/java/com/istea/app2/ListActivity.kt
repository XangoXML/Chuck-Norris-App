package com.istea.app2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity() {
    private lateinit var listViewStudents: ListView
    private lateinit var students: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listViewStudents = findViewById(R.id.listViewStudents)
        students = mutableListOf()

        val name = intent.getStringExtra("name")
        if (!name.isNullOrEmpty()) {
            students.add(name)
        }

        students.add("Juan Carlos Batman")
        students.add("Bruce Wayne")
        students.add("Wanda Maximoff")
        students.add("Charles Xavier")
        students.add("Steve Rogers")

        val adapter = object : ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, students) {
            override fun getView(position: Int, convertView: View?, parent: android.view.ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                if (students[position] == name) {
                    view.setBackgroundColor(Color.parseColor("#FFA500"))
                } else {
                    view.setBackgroundColor(Color.TRANSPARENT)
                }
                return view
            }
        }
        listViewStudents.adapter = adapter

        listViewStudents.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedName = students[position]
            if (selectedName == "Steve Rogers") {
                val intent = Intent(this@ListActivity, DetailActivity::class.java)
                intent.putExtra("name", selectedName)
                startActivity(intent)
            }
        }
    }
}
