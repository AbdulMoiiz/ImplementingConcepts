package com.example.practice.database.sqlite_db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

         companion object{
             private const val DB_VERSION=1
             private const val DB_NAME="MyDb"

             private const val TABLE_NAME="MyTable"
             private const val COLUMN_ID="id"
             private const val COLUMN_NAME="name"
             private const val COLUMN_PHONE="phone"

         }


    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_NAME TEXT, $COLUMN_PHONE TEXT)"
        db?.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val query = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(query)
        onCreate(db)
    }

    fun dropTable() {
        val db = this.writableDatabase
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
    }

    fun insertData(name: String, phone: String){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, name)
        contentValues.put(COLUMN_PHONE, phone)
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }

    fun fetchData(): List<UserModel>{
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        val userList = mutableListOf<UserModel>()
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
                val name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME))
                val phone = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PHONE))
                userList.add(UserModel(id, name, phone))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return userList
    }

    fun updateData(user: UserModel){
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(COLUMN_PHONE, user.phone)
        db.update(TABLE_NAME, contentValues, "$COLUMN_ID=?", arrayOf(user.id.toString()))
        db.close()
    }

    fun deleteData(user: UserModel){
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "$COLUMN_ID=?", arrayOf(user.id.toString()))
        db.close()
    }

    fun deleteAllData(){
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_NAME")
        db.close()
    }

}