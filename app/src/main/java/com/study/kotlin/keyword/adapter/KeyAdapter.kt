package com.study.kotlin.keyword.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.study.kotlin.keyword.R
import com.study.kotlin.keyword.controller.KeyListActivity
import com.study.kotlin.keyword.model.KeyVO
import kotlinx.android.synthetic.main.key_item.view.*

class KeyAdapter(
    private val context: Context,
    private val keyList: List<KeyVO>,
    private val onCLick: ((Int) -> Unit)
): RecyclerView.Adapter<KeyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.key_item, parent, false)
        return KeyViewHolder(view)
    }

    override fun getItemCount(): Int = keyList.size

    override fun onBindViewHolder(holder: KeyViewHolder, position: Int) {

        val key = keyList[position]

        with(holder.itemView){

            textViewTitle.text = key.title;
            textViewLogin.text = key.login;
            textViewPassword.text = key.password;

            this.setOnClickListener {
                KeyListActivity.selectedItem = key
            }
        }
    }
}

class KeyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)