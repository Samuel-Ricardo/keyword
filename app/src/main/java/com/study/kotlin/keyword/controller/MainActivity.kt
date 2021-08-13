package com.study.kotlin.keyword.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.study.kotlin.keyword.R
import com.study.kotlin.keyword.controller.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun nextPage(view: View) {

        val itent:Intent = Intent(this, KeyListActivity::class.java);
        startActivity(itent);
    }
}
