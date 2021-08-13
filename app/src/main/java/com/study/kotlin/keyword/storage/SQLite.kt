package com.study.kotlin.keyword.storage

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLite(
    context:Context
): SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    CURRENT_VERSION
){
    
    companion object {
        private val DATABASE_NAME = "keyword.db"
        private val CURRENT_VERSION =  1
    }

    val TABLE_NAME = "key"
    val COLUMNS_ID = "id"
    val COLUMNS_NAME = "name"
    val COLUMNS_LOGIN = "login"
    val COLUMNS_PASSWORD = "password"
    val DROP_TABLE = "DROP TABLE IF EXIST $TABLE_NAME"
    val CREATE_TABLE = "CREATE TABLE $TABLE_NAME (" +
            "$COLUMNS_ID INTEGER NOT NULL," +
            "$COLUMNS_NAME TEXT NOT NULL," +
            "$COLUMNS_LOGIN TEXT NOT NULL," +
            "$COLUMNS_PASSWORD TEXT NOT NULL," +
            "" +
            "PRIMARY KEY($COLUMNS_ID AUTOINCREMENT)" +
            ")"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(
        database: SQLiteDatabase?,
        oldVersion:Int,
        newVersion:Int){

        if (oldVersion != newVersion) {
            database?.execSQL(DROP_TABLE)
        }
        onCreate(database)
    }


}