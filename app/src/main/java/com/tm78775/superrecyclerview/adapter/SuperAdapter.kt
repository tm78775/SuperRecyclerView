package com.tm78775.superrecyclerview.adapter

import androidx.recyclerview.widget.RecyclerView
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

        val start = dataSource!!.getItemCount()
        dataSource!!.addPageOfItems(items)
        notifyItemRangeInserted(start, items.count())
    }

}