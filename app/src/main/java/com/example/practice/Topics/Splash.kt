package com.example.practice.Topics

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.practice.MainActivity
import com.example.practice.R
import com.example.practice.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {
    lateinit var dataBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dataBinding=DataBindingUtil.setContentView(this, R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val move=android.view.animation.AnimationUtils.loadAnimation(this, R.anim.move)
        val alpha=android.view.animation.AnimationUtils.loadAnimation(this, R.anim.alpha)
        val rotate=android.view.animation.AnimationUtils.loadAnimation(this, R.anim.rotate)
        val scale=android.view.animation.AnimationUtils.loadAnimation(this, R.anim.scale)
        dataBinding.btnTranslate.setOnClickListener {
            dataBinding.txtAnim.startAnimation(move)
        }
        dataBinding.btnRotate.setOnClickListener {
            dataBinding.txtAnim.startAnimation(rotate)
        }
        dataBinding.btnScale.setOnClickListener {
            dataBinding.txtAnim.startAnimation(scale)
        }
        dataBinding.btnAlpha.setOnClickListener {
            dataBinding.txtAnim.startAnimation(alpha)
        }
//        CoroutineScope(Dispatchers.Main).launch {
//            delay(2000)
//            navigateToHome()
//        }
    }



    private fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}