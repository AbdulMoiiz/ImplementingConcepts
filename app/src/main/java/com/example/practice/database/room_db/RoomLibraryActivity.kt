package com.example.practice.database.room_db

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.databinding.ActivityRoomLibraryBinding

class RoomLibraryActivity : AppCompatActivity() {
    lateinit var binding: ActivityRoomLibraryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
         binding= DataBindingUtil.setContentView(this,R.layout.activity_room_library)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dbHelper: MyDBHelper=MyDBHelper.getInstance(this)

        binding.save.setOnClickListener {
            val title=binding.title.text.toString()
            val amount=binding.amount.text.toString().toInt()
            dbHelper.expenseDao().insert(Expense(title = title, amount = amount))

            val list=dbHelper.expenseDao().getAll() as ArrayList<Expense>
            list.forEach {
                Log.d("TAG", "onCreate: ID: ${it.getId()} TITLE: ${it.getTitle()} AMOUNT: ${it.getAmount()}")
            }
        }


    }
}