package com.study.kotlin.keyword.controller

import android.os.Bundle
import android.view.View
import com.study.kotlin.keyword.R
import com.study.kotlin.keyword.controller.base.BaseActivity
import kotlinx.android.synthetic.main.create_key.*

class CreateKeyActivity: BaseActivity() {

    private var keyId:Int = -1

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_key)
        setupThis();
    }

    private fun setupThis(){

        progressBar2.visibility = View.GONE

    }

    private fun saveKey(){

        progressBar2.visibility = View.VISIBLE

        val name = editTextName.text.toString()
        val login = editTextLogin.text.toString()
        val password = editTextPassword.text.toString()

        Thread(Runnable {
            if()
        })
    }
}