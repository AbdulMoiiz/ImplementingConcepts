package com.example.practice.Topics

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.databinding.ActivityListViewSpinAutoTextBinding

class ListViewSpinAutoText : AppCompatActivity() {
    lateinit var dataBinding: ActivityListViewSpinAutoTextBinding
    var arrNames:MutableList<String> = arrayListOf()
    var autoTextNames:MutableList<String> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dataBinding=DataBindingUtil.setContentView(this, R.layout.activity_list_view_spin_auto_text)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        arrNames.add("Moiz")
        arrNames.add("Ali")
        arrNames.add("Ahmad")
        arrNames.add("Subhan")
        arrNames.add("Ayan")
        arrNames.add("Javed")
        arrNames.add("Khan")
        arrNames.add("Moiz")
        arrNames.add("Ali")
        arrNames.add("Ahmad")
        arrNames.add("Subhan")
        arrNames.add("Ayan")
        arrNames.add("Javed")
        arrNames.add("Khan")
        arrNames.add("Moiz")
        arrNames.add("Ali")
        arrNames.add("Ahmad")
        arrNames.add("Subhan")
        arrNames.add("Ayan")
        arrNames.add("Javed")
        arrNames.add("Khan")

        autoTextNames.add("C")
        autoTextNames.add("C++")
        autoTextNames.add("Java")
        autoTextNames.add("Python")
        autoTextNames.add("Ruby")
        autoTextNames.add("JavaScript")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrNames)
        val autoTextAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, autoTextNames)
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arrNames)
        dataBinding.listView.setAdapter(adapter)
        dataBinding.listView.setOnItemClickListener { parent, view, position, id ->
            if (position == 0) {
                Toast.makeText(this, "Moiz", Toast.LENGTH_SHORT).show()
            }
        }

        dataBinding.spinner.setAdapter(spinnerAdapter)
        dataBinding.autoCompleteTextView.setAdapter(autoTextAdapter)
        dataBinding.autoCompleteTextView.setThreshold(1)
    }
}