package com.example.diary

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.diary.DatabaseContainer.PersonTable.Companion.DATA
import com.example.diary.DatabaseContainer.PersonTable.Companion.ID
import com.example.diary.DatabaseContainer.PersonTable.Companion.TABLE_NAME

class DatabaseHelper(context: Context, DATABASE_NAME: String = "diary.db", DATABASE_VERSION: Int = 1):SQLiteOpenHelper(context, DATABASE_NAME,null,DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val diary = "CREATE TABLE " +
                TABLE_NAME + "(" +
                ID + " TEXT PRIMARY KEY, " +
                DATA + " TEXT " + ")"
        db!!.execSQL(diary)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    fun insert(id : String ,data : String) : Boolean{
        val db: SQLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(ID,id)
        contentValues.put(DATA,data)
        val insert_data = db.insert(TABLE_NAME,null,contentValues)
        db.close()
        return !insert_data.equals(-1)
    }
    fun read() : Cursor {
        val db : SQLiteDatabase = this.writableDatabase
        val read : Cursor = db.rawQuery("SELECT $ID FROM $TABLE_NAME",null)
        return read
    }
}