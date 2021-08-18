package com.study.kotlin.keyword.controller;

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.kotlin.keyword.R
import com.study.kotlin.keyword.adapter.KeyAdapter
import com.study.kotlin.keyword.application.KeywordApplication
import com.study.kotlin.keyword.controller.base.BaseActivity
import com.study.kotlin.keyword.model.KeyVO
import kotlinx.android.synthetic.main.create_key.*
import kotlinx.android.synthetic.main.key_list.*

public class KeyListActivity : BaseActivity() {

    private var adapter: KeyAdapter? = null;
   // private val database = KeywordApplication.instance.database

    companion object {
        var selectedItem: KeyVO? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.key_list)
        setupToolBar(toolbar, "Lista de Chaves", false)
        setup();
    }

    override fun onResume() {
        super.onResume()
        search();
    }

    private fun setup() {
        recyclerView2.layoutManager = LinearLayoutManager(this)
    }

    fun goToCreate(view: View) {

        selectedItem = null;

        var intent: Intent = Intent(this, CreateKeyActivity::class.java)
        startActivity(intent);
    }

    fun onClickItem(index: Int) {
        val intent = Intent(this, CreateKeyActivity::class.java)

        intent.putExtra("index", index)

        startActivity(intent);
    }

    fun search() {

        isInProgress(true);

        val search = editTextSearch.text.toString();

        Thread(Runnable {

            runOnUiThread {
                Toast.makeText(this, "Buscando por $search", Toast.LENGTH_SHORT).show()
            }

            var filteredList: List<KeyVO> = mutableListOf();


                filteredList = KeywordApplication.instance.database?.select(search) ?: mutableListOf<KeyVO>()


            runOnUiThread {
                adapter = KeyAdapter(this, filteredList) { onClickItem(it) }

                recyclerView2.adapter = adapter;

                isInProgress(false);
            }
        }).start()
    }

    fun onClickSearch(view: View) {

        search();
    }

    private fun isInProgress(Is: Boolean) {

        if (Is) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}
