package com.study.kotlin.keyword.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.study.kotlin.keyword.R
import com.study.kotlin.keyword.controller.base.BaseActivity
import kotlinx.android.synthetic.main.example_list.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun next_page(view: View) {

        val nextPage:Intent = Intent(this, KeyListActivity::class.java)
        startActivity(nextPage);
    }
}
