package com.example.practice.implicit_intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.databinding.ActivityImplicitIntentBinding

class ImplicitIntentActivity : AppCompatActivity() {
    lateinit var binding: ActivityImplicitIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_implicit_intent)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnMsg.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.setData(Uri.parse("smsto:"+Uri.encode("+9999999999")))
            intent.putExtra(Intent.EXTRA_TEXT,"Please solve this problem")
            intent.putExtra("sms_body", "The SMS text")
            startActivity(intent)

        }

        binding.btnDial.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:9999999999"))
            startActivity(intent)
        }

        binding.btnEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("message/rfc822")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("john.mckinley@examplepetstore.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "This is subject")
            intent.putExtra(Intent.EXTRA_TEXT, "This is body")
            startActivity(Intent.createChooser(intent, "Email using"))
        }

        binding.btnShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT, "This is body")
            startActivity(intent)

        }
    }
}