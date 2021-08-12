package com.study.kotlin.keyword.controller;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.study.kotlin.keyword.R
import com.study.kotlin.keyword.controller.base.BaseActivity
import kotlinx.android.synthetic.main.example_list.*

public class KeyListActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.key_list)
        setupToolBar(toolBar, "Lista de Chaves", false)
    }
}
