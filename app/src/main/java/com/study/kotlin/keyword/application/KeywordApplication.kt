package com.study.kotlin.keyword.application

import android.app.Application
import com.study.kotlin.keyword.storage.SQLite

class KeywordApplication: Application() {

    var database: SQLite? = null
        private set

    companion object {
        lateinit var instance: KeywordApplication
    }


}