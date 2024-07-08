package com.example.practice.custom_toast

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.databinding.ActivityCustomToastBinding
import com.example.practice.databinding.CustomToastBinding

class CustomToastActivity : AppCompatActivity() {
    lateinit var binding: ActivityCustomToastBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_custom_toast)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnClick.setOnClickListener {
            val inflater = LayoutInflater.from(this)
            val bindingT: CustomToastBinding = CustomToastBinding.inflate(inflater)

            bindingT.txtMessage.setText("Message sent successfully!")
            var toast = Toast(this)
            toast.view = bindingT.root
            toast.duration = Toast.LENGTH_SHORT
            toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, -100)
            toast.show()
        }

    }
}