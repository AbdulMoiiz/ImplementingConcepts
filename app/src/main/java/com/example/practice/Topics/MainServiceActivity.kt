package com.example.practice.Topics

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.databinding.ActivityMainServiceBinding

class MainServiceActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dataBinding=DataBindingUtil.setContentView(this, R.layout.activity_main_service)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        dataBinding.startService.setOnClickListener {
            startService(Intent(this, MusicService::class.java))
        }
        dataBinding.stopService.setOnClickListener {
            stopService(Intent(this, MusicService::class.java))
        }
    }
}