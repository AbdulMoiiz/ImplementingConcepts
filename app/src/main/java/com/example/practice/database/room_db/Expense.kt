package com.example.practice.database.room_db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense")
class Expense(

    @PrimaryKey(autoGenerate = true)
    private var id: Int=0,

    @ColumnInfo(name = "title")
    private var title: String,

    @ColumnInfo(name = "amount")
    private var amount: Int,

) {
    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getTitle(): String {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getAmount(): Int {
        return amount
    }

    fun setAmount(amount: Int) {
        this.amount = amount
    }
}