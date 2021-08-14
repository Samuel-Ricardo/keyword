package com.study.kotlin.keyword.controller

import android.os.Bundle
import android.view.View
import com.study.kotlin.keyword.R
import com.study.kotlin.keyword.application.KeywordApplication
import com.study.kotlin.keyword.controller.base.BaseActivity
import com.study.kotlin.keyword.model.KeyVO
import kotlinx.android.synthetic.main.create_key.*

class CreateKeyActivity: BaseActivity() {

    private var keyId:Int = -1
    var selectedKey = KeyListActivity.selectedItem

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_key)
        setupThis();
    }

    private fun setupThis(){

        progressBar2.visibility = View.GONE

    }

    public fun onSavePress(view: View){

        progressBar2.visibility = View.VISIBLE

        val name = editTextName.text.toString()
        val login = editTextLogin.text.toString()
        val password = editTextPassword.text.toString()


        var id = selectedKey?.id ?: -1

        var key = KeyVO(
            id,
            name,
            login,
            password
        )

        if (key != null)

        Thread(Runnable {
            KeywordApplication.instance.database!!.saveKey(key)

            runOnUiThread{
                progressBar2.visibility = View.GONE
                finish()
            }
        }).start()
    }


}