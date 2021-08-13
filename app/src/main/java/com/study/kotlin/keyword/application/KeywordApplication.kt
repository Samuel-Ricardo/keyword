package com.study.kotlin.keyword.application

import android.app.Application
import com.study.kotlin.keyword.storage.SQLite

class KeywordApplication: Application() {

    var database: SQLite? = null
        private set

    companion object {
        lateinit var instance: KeywordApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = SQLite(this)
    }
}