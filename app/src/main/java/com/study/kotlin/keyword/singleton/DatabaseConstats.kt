package com.study.kotlin.keyword.singleton

object DatabaseConstats {

    val TABLE_NAME = "key"

    val COLUMNS_ID = "id"
    val COLUMNS_NAME = "name"
    val COLUMNS_LOGIN = "login"
    val COLUMNS_PASSWORD = "password"

    val SELECT_ALL = "SELECT * FROM $TABLE_NAME"
    val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    val CREATE_TABLE = "CREATE TABLE $TABLE_NAME (" +
            "$COLUMNS_ID INTEGER NOT NULL," +
            "$COLUMNS_NAME TEXT NOT NULL," +
            "$COLUMNS_LOGIN TEXT NOT NULL," +
            "$COLUMNS_PASSWORD TEXT NOT NULL," +
            "" +
            "PRIMARY KEY($COLUMNS_ID AUTOINCREMENT)" +
            ")"
}