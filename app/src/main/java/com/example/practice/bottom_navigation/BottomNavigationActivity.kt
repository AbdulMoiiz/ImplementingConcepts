package com.example.practice.bottom_navigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.practice.R
import com.example.practice.databinding.ActivityBottomNavigationBinding

class BottomNavigationActivity : AppCompatActivity() {
    lateinit var binding: ActivityBottomNavigationBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= DataBindingUtil.setContentView(this,R.layout.activity_bottom_navigation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navController= supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container)?.findNavController()!!
        binding.bottomNavigation.setupWithNavController(navController)


//        binding.bottomNavigation.setOnItemSelectedListener {
//            when(it.itemId){
//                R.id.homeFragment -> {
//                    navController.navigate(R.id.homeFragment)
//                    true
//                }
//                R.id.slideshowFragment -> {
//                    navController.navigate(R.id.slideshowFragment)
//                    true
//                }
//                R.id.galleryFragment -> {
//                    navController.navigate(R.id.galleryFragment)
//                    true
//                }
//                else -> {
//                    false
//                }
//            }
//        }
    }
}