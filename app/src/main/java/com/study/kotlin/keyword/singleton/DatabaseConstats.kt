package com.study.kotlin.keyword.singleton

object DatabaseConstats {

    val TABLE_NAME = "key"

    val COLUMNS:Columns = Columns

    val SELECT_ALL = "SELECT * FROM $TABLE_NAME"
    val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    val CREATE_TABLE = "CREATE TABLE $TABLE_NAME (" +
            "${COLUMNS.ID} INTEGER NOT NULL," +
            "${COLUMNS.NAME} TEXT NOT NULL," +
            "${COLUMNS.LOGIN} TEXT NOT NULL," +
            "${COLUMNS.PASSWORD} TEXT NOT NULL," +
            "" +
            "PRIMARY KEY(${COLUMNS.ID} AUTOINCREMENT)" +
            ")"
}

object Columns {

    val ID = "id"
    val NAME = "name"
    val LOGIN = "login"
    val PASSWORD = "password"
}