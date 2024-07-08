package com.example.practice.database.room_db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expense")
    fun getAll(): List<Expense>

    @Insert
    fun insert(expense: Expense)

    @Update
    fun update(expense: Expense)

    @Delete
    fun delete(expense: Expense)

}