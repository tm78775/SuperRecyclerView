package com.tm78775.superrecyclerview.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.tm78775.superrecyclerview.R

class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var textView: TextView? = view.findViewById<TextView>(R.id.textView)
}