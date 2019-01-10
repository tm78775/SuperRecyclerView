package com.tm78775.superrecyclerview.datasource

abstract class SuperDataSource <T> {

    // region Abstract Method Definitions

    /**
     * This method should remove item by allowing object comparison in child class.
     * @param item item to be removed.
     */
    abstract fun removeItem(item: T)

    /**
     * This method should return an item by doing object comparison in child class.
     * @param item index of the item to be returned.
     * @return int index of the item found in the data source, or -1 if not found.
     */
    abstract fun getItemIndex(item: T): Int

    /**
     * In the event a sort is needed on the items, the child class should handle how
     * to sort the items.
     */
    abstract fun sort()

    // endregion

    // region Private Variables

    protected val dataSource: MutableList<T> = mutableListOf()
    var sectionTitle: String? = null

    // endregion

    // region API

    /**
     * This method will set the data source for this adapter. By setting the data source,
     * it will clear any items that were previously in the data source.
     * @param items list of items which is our new data source.
     */
    fun setDataSource(items: List<T>) {
        dataSource.clear()
        dataSource.addAll(items)
    }

    /**
     * This method will return the number of items in the data source.
     */
    fun getItemCount(): Int {
        return dataSource.count()
    }

    /**
     * This method will get the item at the provided index.
     * @param index index into the data source.
     */
    fun getItem(index: Int): T {
        return dataSource[index]
    }

    /**
     * This method will add a single item to our data source to be appended at the end of
     * the list if no position was added. It will be entered in the position if the position
     * is provided.
     * @param item the item which will be appended to the list.
     * @param index the index into the data source into which the item will be entered.
     */
    fun addItem(item: T, index: Int = -1) {
        if(index < 0)
            dataSource.add(item)
        else
            dataSource.add(index, item)
    }

    /**
     * This method will append items to the end of the data source.
     * @param items list of items to be appended to the end of the list.
     */
    fun addPageOfItems(items: List<T>) {
        dataSource.addAll(items)
    }

    /**
     * This method will remove the item in the list by index.
     *
     */
    fun removeItem(index: Int) {
        dataSource.removeAt(index)
    }

    // endregion

}