package com.study.kotlin.keyword.controller.base

import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.study.kotlin.keyword.R
import kotlinx.android.synthetic.main.example_list.*

open class BaseActivity : AppCompatActivity() {

    protected fun setupToolBar(toolbar: Toolbar, title:String, navigationBack: Boolean){
        toolBar.title = title
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(navigationBack)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

       when(item.itemId) {

           R.id.home -> {
               this.onBackPressed()
               return true
           }
       }

        return super.onOptionsItemSelected(item)
    }
}