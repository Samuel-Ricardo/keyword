package com.study.kotlin.keyword.controller

import android.os.Bundle
import com.study.kotlin.keyword.R
import com.study.kotlin.keyword.controller.base.BaseActivity

class CreateKeyActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_key)
    }
}