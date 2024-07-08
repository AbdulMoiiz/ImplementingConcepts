package com.example.practice.database.sqlite_db

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practice.R

class SqliteMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sqlite_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dbHelper = MyDbHelper(this)

        /*dbHelper.insertData("Test", "9267676767")
        dbHelper.insertData("Test2", "9267676767")
        dbHelper.insertData("Test3", "9267676767")
        dbHelper.insertData("Test4", "9267676767")*/

        /*val userUpdate = UserModel(1, "Test", "1122334455")
        dbHelper.updateData(userUpdate)*/

        val userDelete = UserModel(19, "Test", "9999999999")
        dbHelper.deleteData(userDelete)

        val users: List<UserModel> = dbHelper.fetchData()
        users.forEach { user ->
            Log.d("TAG", "onCreate:  ID: ${user.id}, Name: ${user.name}, Phone: ${user.phone}", )
        }
    }
}