package com.tm78775.superrecyclerview.adapter

import android.support.v7.widget.RecyclerView
import com.tm78775.superrecyclerview.datasource.SuperDataSource

abstract class SuperAdapter<T>: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var dataSource: SuperDataSource<T>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return dataSource?.getItemCount() ?: 0
    }

    fun appendToDataSource(items: List<T>) {
        if(dataSource == null)
            return

        val start = dataSource!!.getItemCount().minus(1)
        notifyItemRangeInserted(start, items.count())
    }

}