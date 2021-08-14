package com.study.kotlin.keyword.controller;

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.study.kotlin.keyword.R
import com.study.kotlin.keyword.controller.base.BaseActivity
import com.study.kotlin.keyword.model.KeyVO
import kotlinx.android.synthetic.main.example_list.*

public class KeyListActivity: BaseActivity() {

    companion object {
        var selectedItem:KeyVO? = null
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.key_list)
        setupToolBar(toolBar, "Lista de Chaves", false)
    }

    fun goToCreate(view: View) {

        var intent:Intent = Intent(this, CreateKeyActivity::class.java)
        startActivity(intent);
    }
}
