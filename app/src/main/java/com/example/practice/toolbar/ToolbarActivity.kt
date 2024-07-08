package com.example.practice.toolbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.databinding.ActivityToolbarBinding
import com.example.practice.databinding.ToolbarBinding

class ToolbarActivity : AppCompatActivity() {
    lateinit var binding: ActivityToolbarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_toolbar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.includeToolbar.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.includeToolbar.toolbar.setNavigationOnClickListener {
            finish()
        }
        supportActionBar?.title ="My Toolbar"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.opt_new->{
                Toast.makeText(this, "New", Toast.LENGTH_SHORT).show()
            }
            R.id.opt_save->{
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
            }
            R.id.opt_share->{
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
            }
            R.id.opt_delete->{
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}