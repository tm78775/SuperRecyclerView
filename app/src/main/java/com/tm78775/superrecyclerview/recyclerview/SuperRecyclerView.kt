package com.tm78775.superrecyclerview.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log

class SuperRecyclerView: RecyclerView {

    //region Private Variables

    private val tag = "SuperRecyclerView"
    private var onBottomOfRecyclerViewCalled = false
    private var onBottomListenerCallback: (() -> Unit)? = null

    //endregion

    //region Constructor(s)

    constructor(context: Context) : super(context) { initializeOnBottomReachedListener() }
    constructor(context: Context, set: AttributeSet) : super(context, set) { initializeOnBottomReachedListener() }
    constructor(context: Context, set: AttributeSet, defStyle: Int) : super(context, set, defStyle) { initializeOnBottomReachedListener() }

    //endregion

    //region Initializing Code

    /**
     * This method will attach an onScrollListener to the RecyclerView to determine when it has reached the bottom of the
     * data set. It can then call the appropriate methods to allow for loading of more data.
     */
    private fun initializeOnBottomReachedListener() {
        this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(dy < 0) {
                    // scrolling up
                } else if(dy > 0) {
                    if(!canScrollVertically(RecyclerView.FOCUS_DOWN)) {
                        Log.d(tag, "Bottom of recycler view reached.")
                        if(!onBottomOfRecyclerViewCalled && onBottomListenerCallback != null) {
                            onBottomOfRecyclerViewCalled = true
                            onBottomListenerCallback?.invoke()
                            Log.d(tag, "INVOKED BOTTOM LISTENER CALLBACK.")
                        } else {
                            Log.d(tag, "Not calling onBottomOfRecyclerView because onAdditionalItemsLoaded has not been called to reset the listener.")
                        }
                    }
                }

            }
        })
    }

    //endregion

    //region API

    /**
     * This method provides an API allowing the implementation to "reset" the onBottomReachedCallback
     * flag. Once this flag has been reset, then the onBottomReached method will be called when the
     * recyclerview once again reaches the bottom of the screen.
     */
    fun onAdditionalItemsLoaded() {
        onBottomOfRecyclerViewCalled = false
    }

    /**
     * This method provides an API allowing the implementation to add a bottom listener to this
     * RecyclerView.
     */
    fun setOnBottomListener(callback: (() -> Unit)?) {
        onBottomListenerCallback = callback
    }

    //endregion

}