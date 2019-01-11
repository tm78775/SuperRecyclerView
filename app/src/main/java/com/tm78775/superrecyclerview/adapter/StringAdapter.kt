package com.tm78775.superrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tm78775.superrecyclerview.R
import com.tm78775.superrecyclerview.viewholder.MyViewHolder

class StringAdapter: SuperAdapter<String>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.rv_item, p0, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        (p0 as? MyViewHolder)?.textView?.text = dataSource?.getItem(p1)
    }

}