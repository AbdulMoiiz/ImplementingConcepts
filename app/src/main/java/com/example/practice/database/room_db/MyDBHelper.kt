package com.example.practice.database.room_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Expense::class], exportSchema = false, version = 1)
abstract class MyDBHelper : RoomDatabase() {

    abstract fun expenseDao(): ExpenseDao

    companion object{
        @Volatile
        private var instance: MyDBHelper? = null
        private const val DATABASE_NAME = "expense-db"

        @Synchronized
        fun getInstance(context: Context) : MyDBHelper {
            if (instance == null) {
                instance = Room.databaseBuilder(context, MyDBHelper::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries() //allow queries to run on main thread
                    .build()
            }
            return instance!!
            /*return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    MyDBHelper::class.java,
                    DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries() // Allow queries to run on the main thread
                    .build()
                    .also { instance = it }
            }*/
        }
    }

}