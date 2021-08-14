package com.study.kotlin.keyword.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.study.kotlin.keyword.model.KeyVO

class KeyAdapter(
    private val context: Context,
    private val keyList: List<KeyVO>,
    private val onCLick: ((int) -> Unit)
): RecyclerView.Adapter<KeyViewHolder>() {

}