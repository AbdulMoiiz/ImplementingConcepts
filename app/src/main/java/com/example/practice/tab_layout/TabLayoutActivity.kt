package com.example.practice.tab_layout

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.databinding.ActivityTabLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutActivity : AppCompatActivity() {
    lateinit var binding: ActivityTabLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_tab_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter=ViewPagerMessengerAdapter(this)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab,position->
            tab.text=adapter.getPageTitle(position)
            tab.icon=AppCompatResources.getDrawable(this,R.drawable.baseline_assignment_turned_in_24)
        }.attach()


    }
}