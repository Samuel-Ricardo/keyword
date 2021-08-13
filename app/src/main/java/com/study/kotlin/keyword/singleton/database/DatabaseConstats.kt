package com.study.kotlin.keyword.singleton.database

object DatabaseConstats {

    val TABLE_NAME = "key"

    val COLUMNS: Columns = Columns

    val SELECT_ALL = "SELECT * FROM $TABLE_NAME"
    val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    val CREATE_TABLE = "CREATE TABLE $TABLE_NAME (" +
            "${Columns.ID} INTEGER NOT NULL," +
            "${Columns.NAME} TEXT NOT NULL," +
            "${Columns.LOGIN} TEXT NOT NULL," +
            "${Columns.PASSWORD} TEXT NOT NULL," +
            "" +
            "PRIMARY KEY(${Columns.ID} AUTOINCREMENT)" +
            ")"
}



