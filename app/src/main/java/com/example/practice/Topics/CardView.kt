package com.example.practice.Topics

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.databinding.ActivityCardViewBinding

class CardView : AppCompatActivity() {
    lateinit var dataBinding: ActivityCardViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dataBinding= DataBindingUtil.setContentView(this, R.layout.activity_card_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*dataBinding.cardView.radius=10f
        dataBinding.cardView.elevation=10f
        dataBinding.cardView.useCompatPadding=true*/


    }
}