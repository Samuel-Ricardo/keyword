package com.study.kotlin.keyword.controller;

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.kotlin.keyword.R
import com.study.kotlin.keyword.adapter.KeyAdapter
import com.study.kotlin.keyword.controller.base.BaseActivity
import com.study.kotlin.keyword.model.KeyVO
import kotlinx.android.synthetic.main.example_list.*
import kotlinx.android.synthetic.main.key_list.*

public class KeyListActivity: BaseActivity() {

    private var adapter:KeyAdapter? = null;

    companion object {
        var selectedItem:KeyVO? = null
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.key_list)
        setupToolBar(toolBar, "Lista de Chaves", false)
    }

    override fun onResume() {
        super.onResume()
        search()
    }

    private fun setup(){
        recyclerView2.layoutManager = LinearLayoutManager(this)
    }

    fun goToCreate(view: View) {

        selectedItem = null;

        var intent:Intent = Intent(this, CreateKeyActivity::class.java)
        startActivity(intent);
    }

    fun onItemClick(index: Int) {
        val intent = Intent(this, CreateKeyActivity::class.java)

        intent.putExtra("index", index)

        startActivity(intent);
    }
}
