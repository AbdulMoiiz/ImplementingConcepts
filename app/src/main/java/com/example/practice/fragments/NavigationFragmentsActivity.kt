package com.example.practice.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.databinding.ActivityNavigationFragmentsBinding

class NavigationFragmentsActivity : AppCompatActivity() {
    lateinit var binding: ActivityNavigationFragmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= DataBindingUtil.setContentView(this,R.layout.activity_navigation_fragments)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportFragmentManager.beginTransaction().add(R.id.fragment_container,AFragment()).commit()

        binding.btnA.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,AFragment()).commit()
        }
        binding.btnB.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,BFragment()).commit()
        }
        binding.btnC.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,CFragment()).commit()
        }
    }
}