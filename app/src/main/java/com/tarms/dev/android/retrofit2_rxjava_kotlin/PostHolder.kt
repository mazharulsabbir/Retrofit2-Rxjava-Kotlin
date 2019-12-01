package com.tarms.dev.android.retrofit2_rxjava_kotlin

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.title)
    val uId: TextView = itemView.findViewById(R.id.user_id)
    val body: TextView = itemView.findViewById(R.id.body)
}