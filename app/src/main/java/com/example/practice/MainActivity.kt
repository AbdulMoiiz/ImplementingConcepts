package com.example.practice

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.practice.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    lateinit var dataBinding:ActivityMainBinding

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dataBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        GlobalScope.launch(Dispatchers.IO) {
            while (true){
                delay(300)
                withContext(Dispatchers.Main){
                    dataBinding.center.setBackgroundColor(Color.BLACK)
                    dataBinding.leftLCenter.setBackgroundColor(Color.BLACK)
                    dataBinding.rightRCenter.setBackgroundColor(Color.BLACK)
                    dataBinding.leftTopCenter.setBackgroundColor(Color.BLACK)
                    dataBinding.rightTopCenter.setBackgroundColor(Color.BLACK)
                    dataBinding.leftBottomCenter.setBackgroundColor(Color.BLACK)
                    dataBinding.rightBottomCenter.setBackgroundColor(Color.BLACK)

                    dataBinding.leftCenter.setBackgroundColor(Color.WHITE)
                    dataBinding.rightCenter.setBackgroundColor(Color.WHITE)
                    dataBinding.topCenter.setBackgroundColor(Color.WHITE)
                    dataBinding.leftLTopCenter.setBackgroundColor(Color.WHITE)
                    dataBinding.rightRTopCenter.setBackgroundColor(Color.WHITE)
                    dataBinding.bottomCenter.setBackgroundColor(Color.WHITE)
                    dataBinding.rightRBottomCenter.setBackgroundColor(Color.WHITE)
                    dataBinding.leftLBottomCenter.setBackgroundColor(Color.WHITE)
                }
                delay(300)
                withContext(Dispatchers.Main){
                    dataBinding.center.setBackgroundColor(Color.WHITE)
                    dataBinding.leftLCenter.setBackgroundColor(Color.WHITE)
                    dataBinding.rightRCenter.setBackgroundColor(Color.WHITE)
                    dataBinding.leftTopCenter.setBackgroundColor(Color.WHITE)
                    dataBinding.rightTopCenter.setBackgroundColor(Color.WHITE)
                    dataBinding.leftBottomCenter.setBackgroundColor(Color.WHITE)
                    dataBinding.rightBottomCenter.setBackgroundColor(Color.WHITE)

                    dataBinding.leftCenter.setBackgroundColor(Color.BLACK)
                    dataBinding.rightCenter.setBackgroundColor(Color.BLACK)
                    dataBinding.topCenter.setBackgroundColor(Color.BLACK)
                    dataBinding.leftLTopCenter.setBackgroundColor(Color.BLACK)
                    dataBinding.rightRTopCenter.setBackgroundColor(Color.BLACK)
                    dataBinding.bottomCenter.setBackgroundColor(Color.BLACK)
                    dataBinding.rightRBottomCenter.setBackgroundColor(Color.BLACK)
                    dataBinding.leftLBottomCenter.setBackgroundColor(Color.BLACK)
                }
            }
        }
    }
}