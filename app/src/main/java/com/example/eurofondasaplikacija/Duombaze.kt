package com.example.eurofondasaplikacija

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Duombaze(context: Context):SQLiteOpenHelper(context,"VartDuom", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table VartDuom (slapyvardis TEXT primary key, slaptazodis TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists VartDuom")
    }

    fun insertdata(slapyvardis: String, slaptazodis: String): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("slapyvardis", slapyvardis)
        cv.put("slaptazodis", slaptazodis)
        val result = db.insert("VartDuom", null, cv)
        if (result==-1 .toLong()){
            return false
        }
        return false
    }

    fun checkuserpass(slapyvardis: String, slaptazodis: String): Boolean{
        val db = this.writableDatabase
        val query = "select * from VartDuom where slapyvardis= '$slapyvardis' and slaptazodis= '$slaptazodis'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
}