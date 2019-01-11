package com.tm78775.superrecyclerview.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tm78775.superrecyclerview.R

class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var textView: TextView? = view.findViewById<TextView>(R.id.textView)
}