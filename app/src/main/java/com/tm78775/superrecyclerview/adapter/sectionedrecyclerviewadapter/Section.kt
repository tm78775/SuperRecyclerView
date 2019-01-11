package com.tm78775.superrecyclerview.adapter.sectionedrecyclerviewadapter

import android.view.ViewGroup
import android.view.View
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView


abstract class Section {

    enum class State {
        LOADING,
        LOADED,
        FAILED,
        EMPTY
    }

    private var state = State.LOADED

    private var visible = true

    private var hasHeader = false
    private var hasFooter = false

    @LayoutRes
    private var itemResourceId: Int? = null
    @LayoutRes
    private var headerResourceId: Int? = null
    @LayoutRes
    private var footerResourceId: Int? = null
    @LayoutRes
    private var loadingResourceId: Int? = null
    @LayoutRes
    private var failedResourceId: Int? = null
    @LayoutRes
    private var emptyResourceId: Int? = null
    private var itemViewWillBeProvided = false
    private var headerViewWillBeProvided = false
    private var footerViewWillBeProvided = false
    private var loadingViewWillBeProvided = false
    private var failedViewWillBeProvided = false
    private var emptyViewWillBeProvided = false

    /**
     * Create a Section object based on [SectionParameters].
     *
     * @param sectionParameters section parameters
     */
    fun Section(sectionParameters: SectionParameters) {
        this.itemResourceId = sectionParameters.itemResourceId
        this.headerResourceId = sectionParameters.headerResourceId
        this.footerResourceId = sectionParameters.footerResourceId
        this.loadingResourceId = sectionParameters.loadingResourceId
        this.failedResourceId = sectionParameters.failedResourceId
        this.emptyResourceId = sectionParameters.emptyResourceId
        this.itemViewWillBeProvided = sectionParameters.itemViewWillBeProvided
        this.headerViewWillBeProvided = sectionParameters.headerViewWillBeProvided
        this.footerViewWillBeProvided = sectionParameters.footerViewWillBeProvided
        this.loadingViewWillBeProvided = sectionParameters.loadingViewWillBeProvided
        this.failedViewWillBeProvided = sectionParameters.failedViewWillBeProvided
        this.emptyViewWillBeProvided = sectionParameters.emptyViewWillBeProvided

        this.hasHeader = this.headerResourceId != null || this.headerViewWillBeProvided
        this.hasFooter = this.footerResourceId != null || this.footerViewWillBeProvided
    }

    /**
     * Set the State of this Section.
     *
     * @param state state of this section
     */
    fun setState(state: State) {
        when (state) {
            State.LOADING -> if (loadingResourceId == null && !loadingViewWillBeProvided) {
                throw IllegalStateException(
                    "Resource id for 'loading state' should be provided or 'loadingViewWillBeProvided' should be set"
                )
            }
            State.FAILED -> if (failedResourceId == null && !failedViewWillBeProvided) {
                throw IllegalStateException("Resource id for 'failed state' should be provided or 'failedViewWillBeProvided' should be set")
            }
            State.EMPTY -> if (emptyResourceId == null && !emptyViewWillBeProvided) {
                throw IllegalStateException("Resource id for 'empty state' should be provided or 'emptyViewWillBeProvided' should be set")
            }
            else -> {
            }
        }

        this.state = state
    }

    /**
     * Return the current State of this Section.
     *
     * @return current state of this section
     */
    fun getState(): State {
        return state
    }

    /**
     * Check if this Section is visible.
     *
     * @return true if this Section is visible
     */
    fun isVisible(): Boolean {
        return visible
    }

    /**
     * Set if this Section is visible.
     *
     * @param visible true if this Section is visible
     */
    fun setVisible(visible: Boolean) {
        this.visible = visible
    }

    /**
     * Check if this Section has a header.
     *
     * @return true if this Section has a header
     */
    fun hasHeader(): Boolean {
        return hasHeader
    }

    /**
     * Set if this Section has header.
     *
     * @param hasHeader true if this Section has a header
     */
    fun setHasHeader(hasHeader: Boolean) {
        this.hasHeader = hasHeader
    }

    /**
     * Check if this Section has a footer.
     *
     * @return true if this Section has a footer
     */
    fun hasFooter(): Boolean {
        return hasFooter
    }

    /**
     * Set if this Section has footer.
     *
     * @param hasFooter true if this Section has a footer
     */
    fun setHasFooter(hasFooter: Boolean) {
        this.hasFooter = hasFooter
    }

    /**
     * Return whether the item view is provided through [.getItemView].
     * If false, the item view is inflated using the resource from [.getItemResourceId].
     *
     * @return whether the item view is provided through [.getItemView].
     */
    fun isItemViewWillBeProvided(): Boolean {
        return itemViewWillBeProvided
    }

    /**
     * Return the layout resource id of the item.
     *
     * @return layout resource id of the item
     */
    fun getItemResourceId(): Int? {
        return itemResourceId
    }

    /**
     * Return whether the header view is provided through [.getHeaderView].
     * If false, the header view is inflated using the resource from
     * [.getHeaderResourceId].
     *
     * @return whether the header view is provided through [.getHeaderView].
     */
    fun isHeaderViewWillBeProvided(): Boolean {
        return headerViewWillBeProvided
    }

    /**
     * Return the layout resource id of the header.
     *
     * @return layout resource id of the header
     */
    fun getHeaderResourceId(): Int? {
        return headerResourceId
    }

    /**
     * Return whether the footer view is provided through [.getFooterView].
     * If false, the footer view is inflated using the resource from
     * [.getFooterResourceId].
     *
     * @return whether the footer view is provided through [.getFooterView].
     */
    fun isFooterViewWillBeProvided(): Boolean {
        return footerViewWillBeProvided
    }

    /**
     * Return the layout resource id of the footer.
     *
     * @return layout resource id of the footer
     */
    fun getFooterResourceId(): Int? {
        return footerResourceId
    }

    /**
     * Return whether the loading view is provided through [.getLoadingView].
     * If false, the loading view is inflated using the resource from
     * [.getLoadingResourceId].
     *
     * @return whether the loading view is provided through [.getLoadingView].
     */
    fun isLoadingViewWillBeProvided(): Boolean {
        return loadingViewWillBeProvided
    }

    /**
     * Return the layout resource id of the loading view.
     *
     * @return layout resource id of the loading view
     */
    fun getLoadingResourceId(): Int? {
        return loadingResourceId
    }

    /**
     * Return whether the failed view is provided through [.getFailedView].
     * If false, the failed view is inflated using the resource from
     * [.getFailedResourceId].
     *
     * @return whether the failed view is provided through [.getFailedView].
     */
    fun isFailedViewWillBeProvided(): Boolean {
        return failedViewWillBeProvided
    }

    /**
     * Return the layout resource id of the failed view.
     *
     * @return layout resource id of the failed view
     */
    fun getFailedResourceId(): Int? {
        return failedResourceId
    }

    /**
     * Return whether the empty view is provided through [.getEmptyView].
     * If false, the empty view is inflated using the resource from
     * [.getEmptyResourceId].
     *
     * @return whether the empty view is provided through [.getEmptyView].
     */
    fun isEmptyViewWillBeProvided(): Boolean {
        return emptyViewWillBeProvided
    }

    /**
     * Return the layout resource id of the empty view.
     *
     * @return layout resource id of the empty view
     */
    fun getEmptyResourceId(): Int? {
        return emptyResourceId
    }

    /**
     * Bind the data to the ViewHolder for the Content of this Section, that can be the Items,
     * Loading view or Failed view, depending on the current state of the section.
     *
     * @param holder   ViewHolder for the Content of this Section
     * @param position position of the item in the Section, not in the RecyclerView
     */
    fun onBindContentViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (state) {
            State.LOADING -> onBindLoadingViewHolder(holder)
            State.LOADED -> onBindItemViewHolder(holder, position)
            State.FAILED -> onBindFailedViewHolder(holder)
            State.EMPTY -> onBindEmptyViewHolder(holder)
        }
    }

    /**
     * Return the total of items of this Section, including content items (according to the section
     * state) plus header and footer.
     *
     * @return total of items of this section
     */
    fun getSectionItemsTotal(): Int {

        val contentItemsTotal =
            when (state) {
                State.LOADING -> 1
                State.LOADED -> getContentItemsTotal()
                State.FAILED -> 1
                State.EMPTY -> 1
            }

        return contentItemsTotal + (if (hasHeader) 1 else 0) + if (hasFooter) 1 else 0
    }

    /**
     * Return the total of items of this Section.
     *
     * @return total of items of this Section
     */
    abstract fun getContentItemsTotal(): Int

    /**
     * Creates the View for a single Item. This must be implemented if and only if
     * [.isItemViewWillBeProvided] is true.
     *
     * @param parent The parent view. Note that there is no need to attach the new view.
     * @return View for an Item of this Section.
     */
    fun getItemView(parent: ViewGroup): View {
        throw UnsupportedOperationException(
            "You need to implement getItemView() if you set itemViewWillBeProvided"
        )
    }

    /**
     * Return the ViewHolder for a single Item of this Section.
     *
     * @param view View created by getItemView or inflated resource returned by getItemResourceId
     * @return ViewHolder for the Item of this Section
     */
    abstract fun getItemViewHolder(view: View): RecyclerView.ViewHolder

    /**
     * Bind the data to the ViewHolder for an Item of this Section.
     *
     * @param holder   ViewHolder for the Item of this Section
     * @param position position of the item in the Section, not in the RecyclerView
     */
    abstract fun onBindItemViewHolder(holder: RecyclerView.ViewHolder, position: Int)

    /**
     * Creates the View for the Header. This must be implemented if and only if
     * [.isHeaderViewWillBeProvided] is true.
     *
     * @param parent The parent view. Note that there is no need to attach the new view.
     * @return View for the Header of this Section.
     */
    open fun getHeaderView(parent: ViewGroup): View {
        throw UnsupportedOperationException(
            "You need to implement getHeaderView() if you set headerViewWillBeProvided"
        )
    }

    /**
     * Return the ViewHolder for the Header of this Section.
     *
     * @param view View inflated by resource returned by getHeaderResourceId
     * @return ViewHolder for the Header of this Section
     */
    fun getHeaderViewHolder(view: View): RecyclerView.ViewHolder {
        return SectionedRecyclerViewAdapter.EmptyViewHolder(view)
    }

    /**
     * Bind the data to the ViewHolder for the Header of this Section.
     *
     * @param holder ViewHolder for the Header of this Section
     */
    fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder) {
        // Nothing to bind here.
    }

    /**
     * Creates the View for the Footer. This must be implemented if and only if
     * [.isFooterViewWillBeProvided] is true.
     *
     * @param parent The parent view. Note that there is no need to attach the new view.
     * @return View for the Footer of this Section.
     */
    fun getFooterView(parent: ViewGroup): View {
        throw UnsupportedOperationException(
            "You need to implement getFooterView() if you set footerViewWillBeProvided"
        )
    }

    /**
     * Return the ViewHolder for the Footer of this Section.
     *
     * @param view View inflated by resource returned by getFooterResourceId
     * @return ViewHolder for the Footer of this Section
     */
    fun getFooterViewHolder(view: View): RecyclerView.ViewHolder {
        return SectionedRecyclerViewAdapter.EmptyViewHolder(view)
    }

    /**
     * Bind the data to the ViewHolder for the Footer of this Section.
     *
     * @param holder ViewHolder for the Footer of this Section
     */
    fun onBindFooterViewHolder(holder: RecyclerView.ViewHolder) {
        // Nothing to bind here.
    }

    /**
     * Creates the View for the Loading state. This must be implemented if and only if
     * [.isLoadingViewWillBeProvided] is true.
     *
     * @param parent The parent view. Note that there is no need to attach the new view.
     * @return View for the Loading state of this Section.
     */
    fun getLoadingView(parent: ViewGroup): View {
        throw UnsupportedOperationException(
            "You need to implement getLoadingView() if you set loadingViewWillBeProvided"
        )
    }

    /**
     * Return the ViewHolder for the Loading state of this Section.
     *
     * @param view View inflated by resource returned by getItemResourceId
     * @return ViewHolder for the Loading state of this Section
     */
    open fun getLoadingViewHolder(view: View): RecyclerView.ViewHolder {
        return SectionedRecyclerViewAdapter.EmptyViewHolder(view)
    }

    /**
     * Bind the data to the ViewHolder for Loading state of this Section.
     *
     * @param holder ViewHolder for the Loading state of this Section
     */
    open fun onBindLoadingViewHolder(holder: RecyclerView.ViewHolder) {
        // Nothing to bind here.
    }

    /**
     * Creates the View for the Failed state. This must be implemented if and only if
     * [.isFailedViewWillBeProvided] is true.
     *
     * @param parent The parent view. Note that there is no need to attach the new view.
     * @return View for the Failed state of this Section.
     */
    fun getFailedView(parent: ViewGroup): View {
        throw UnsupportedOperationException(
            "You need to implement getFailedView() if you set failedViewWillBeProvided"
        )
    }

    /**
     * Return the ViewHolder for the Failed state of this Section.
     *
     * @param view View inflated by resource returned by getItemResourceId
     * @return ViewHolder for the Failed of this Section
     */
    open fun getFailedViewHolder(view: View): RecyclerView.ViewHolder {
        return SectionedRecyclerViewAdapter.EmptyViewHolder(view)
    }

    /**
     * Bind the data to the ViewHolder for the Failed state of this Section.
     *
     * @param holder ViewHolder for the Failed state of this Section
     */
    open fun onBindFailedViewHolder(holder: RecyclerView.ViewHolder) {
        // Nothing to bind here.
    }

    /**
     * Creates the View for the Empty state. This must be implemented if and only if
     * [.isEmptyViewWillBeProvided] is true.
     *
     * @param parent The parent view. Note that there is no need to attach the new view.
     * @return View for the Empty state of this Section.
     */
    fun getEmptyView(parent: ViewGroup): View {
        throw UnsupportedOperationException(
            "You need to implement getEmptyView() if you set emptyViewWillBeProvided"
        )
    }

    /**
     * Return the ViewHolder for the Empty state of this Section.
     *
     * @param view View inflated by resource returned by getItemResourceId
     * @return ViewHolder for the Empty of this Section
     */
    open fun getEmptyViewHolder(view: View): RecyclerView.ViewHolder {
        return SectionedRecyclerViewAdapter.EmptyViewHolder(view)
    }

    /**
     * Bind the data to the ViewHolder for the Empty state of this Section.
     *
     * @param holder ViewHolder for the Empty state of this Section
     */
    open fun onBindEmptyViewHolder(holder: RecyclerView.ViewHolder) {
        // Nothing to bind here.
    }

}