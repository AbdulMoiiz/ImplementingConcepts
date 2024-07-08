package com.example.practice.drawer_navigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.practice.R
import com.example.practice.databinding.ActivityDrawerNavBinding

class DrawerNavActivity : AppCompatActivity() {
    lateinit var binding: ActivityDrawerNavBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= DataBindingUtil.setContentView(this,R.layout.activity_drawer_nav)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        setSupportActionBar(binding.toolbar.toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navController=supportFragmentManager.findFragmentById(R.id.nav_host_fragment)?.findNavController()!!
        binding.navigationView.setupWithNavController(navController)

        val toggle=ActionBarDrawerToggle(this,binding.main,binding.toolbar.toolbar,R.string.open_nav,R.string.close_nav)
        binding.main.addDrawerListener(toggle)
        toggle.syncState()


    }
}