package com.tm78775.superrecyclerview.datasource

class StringDataSource(items: List<String>? = null): SuperDataSource<String>() {

    init {
        if(items != null)
            dataSource.addAll(items)
    }

    override fun getItemIndex(item: String): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeItem(item: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sort() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}