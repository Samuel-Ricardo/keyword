package com.study.kotlin.keyword.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.study.kotlin.keyword.model.KeyVO

class KeyAdapter(
    private val context: Context,
    private val keyList: List<KeyVO>,
    private val onCLick: ((Int) -> Unit)
): RecyclerView.Adapter<KeyViewHolder>() {

    override fun onCreateViewHolder(paernt: ViewGroup, viewType: Int): KeyViewHolder {

    }

    override fun getItemCount(): Int = keyList.size

    override fun onBindViewHolder(holder: KeyViewHolder, position: Int) {

    }
}

class KeyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)