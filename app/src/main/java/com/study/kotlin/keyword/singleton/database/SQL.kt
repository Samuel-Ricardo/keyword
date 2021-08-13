package com.study.kotlin.keyword.singleton.database



class SQL(
    val COLUMNS:Columns
) {
    val SELECT_ALL = "SELECT * FROM ${DatabaseConstats.TABLE_NAME}"
    val DROP_TABLE = "DROP TABLE IF EXISTS ${DatabaseConstats.TABLE_NAME}"
    val CREATE_TABLE = "CREATE TABLE ${DatabaseConstats.TABLE_NAME} (" +
            "${COLUMNS.ID} INTEGER NOT NULL," +
            "${COLUMNS.NAME} TEXT NOT NULL," +
            "${COLUMNS.LOGIN} TEXT NOT NULL," +
            "${COLUMNS.PASSWORD} TEXT NOT NULL," +
            "" +
            "PRIMARY KEY(${COLUMNS.ID} AUTOINCREMENT)" +
            ")"
}