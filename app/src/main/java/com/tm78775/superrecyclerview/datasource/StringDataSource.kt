package com.tm78775.superrecyclerview.datasource

class StringDataSource(items: List<String>? = null): SuperDataSource<String>() {

    init {
        if(items != null)
            dataSource.addAll(items)
    }

    override fun getItemIndex(item: String): Int {
        return dataSource.indexOf(item)
    }

    override fun removeItem(item: String) {
        val index = dataSource.indexOf(item)
        if(index > -1)
            dataSource.removeAt(index)
    }

    override fun sort() {
        // not implemented.
    }

}