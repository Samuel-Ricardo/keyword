package com.study.kotlin.keyword.storage

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.study.kotlin.keyword.model.KeyVO
import com.study.kotlin.keyword.singleton.database.COLUMNS
import com.study.kotlin.keyword.singleton.database.DatabaseConstats.TABLE_NAME
import com.study.kotlin.keyword.singleton.database.SQL.CREATE_TABLE
import com.study.kotlin.keyword.singleton.database.SQL.DELETE_BY_ID
import com.study.kotlin.keyword.singleton.database.SQL.DROP_TABLE
import com.study.kotlin.keyword.singleton.database.SQL.SELECT_ALL

class SQLite(
    context: Context
) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    CURRENT_VERSION
) {

    companion object {
        private const val DATABASE_NAME = "keyword.db"
        private const val CURRENT_VERSION = 1
    }



    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(
        database: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {

        if (oldVersion != newVersion) {
            database?.execSQL(DROP_TABLE)
        }
        onCreate(database)
    }

    fun getById(): KeyVO?{

        return null
    }

    fun generateKey(cursor:Cursor): MutableList<KeyVO> {

        val keyList = mutableListOf<KeyVO>()

        while (cursor.moveToNext()){

            var key = KeyVO(
                cursor.getInt(cursor.getColumnIndex(COLUMNS.ID)),
                cursor.getString(cursor.getColumnIndex(COLUMNS.NAME)),
                cursor.getString(cursor.getColumnIndex(COLUMNS.LOGIN)),
                cursor.getString(cursor.getColumnIndex(COLUMNS.PASSWORD))
            )

            keyList.add(key)
        }

        return keyList;
    }

    fun selectAll(search: String): List<KeyVO> {

        val database = readableDatabase ?: return mutableListOf()
        var args: Array<String> = arrayOf()

        try {

            var cursor = database.rawQuery(
                SELECT_ALL,
                args)

            if (cursor == null) {
                database.close()
                return mutableListOf()
            }


            var keyList = generateKey(cursor)

            database.close();
            return keyList;
        }catch (ex:Exception){

            database.close();
            return mutableListOf();
        }
    }

    fun saveKey(key: KeyVO): Boolean {

        val database = writableDatabase

        try {
            database.insert(
                TABLE_NAME,
                null,
                getContentFrom(key)
            )

        } catch (ex: Exception) {

            database.close();
            return false;
        }

        database.close();
        return true;
    }

    fun deleteKey(id: Int): Boolean {

        val args = arrayOf("$id")

        try {

            execSQL(DELETE_BY_ID, args)

            return true
        } catch (ex: Exception) {

            return false
        }
    }

    fun updateKey(key: KeyVO): Boolean {

        val sql = "UPDATE ${TABLE_NAME}" +
                " SET" +
                "${COLUMNS.NAME} = ?" +
                "${COLUMNS.LOGIN} = ?" +
                "${COLUMNS.PASSWORD} = ?" +
                " WHERE ${COLUMNS.ID} = ? "
        val args = arrayOf(
            key.title,
            key.login,
            key.password,
            key.id,
        )

        try {

            execSQL(sql, args)

            return true
        } catch (ex: Exception) {

            return false
        }
    }


    fun getContentFrom(key: KeyVO): ContentValues {

        var content = ContentValues()

        content.put(COLUMNS.NAME, key.title)
        content.put(COLUMNS.LOGIN, key.login)
        content.put(COLUMNS.PASSWORD, key.password)

        return content;
    }

    fun execSQL(
        sql: String,
        args: Array<*>
    ) {
        val database = writableDatabase

        database.execSQL(sql, args)
        database.close()
    }
}