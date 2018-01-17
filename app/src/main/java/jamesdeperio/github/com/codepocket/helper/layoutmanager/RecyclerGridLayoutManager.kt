package jamesdeperio.github.com.codepocket.helper.layoutmanager

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

/**
 * Created by jamesdeperio on 8/26/2017
 *  jamesdeperio.github.com.codepocket.view
 */
class RecyclerGridLayoutManager(context: Context, spanCount: Int, orientation: Int, reverseLayout: Boolean) : GridLayoutManager(context, spanCount, orientation, reverseLayout) {
    private var isScrollEnabled = true
    fun setScrollEnabled(flag: Boolean) {
        this.isScrollEnabled = flag
    }

    override fun canScrollVertically(): Boolean = isScrollEnabled && super.canScrollVertically()

    override fun canScrollHorizontally(): Boolean = isScrollEnabled && super.canScrollHorizontally()

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State) {
        try {
            super.onLayoutChildren(recycler, state)
        } catch (e: IndexOutOfBoundsException) {
            Log.e("probe", "meet a IOOBE in RecyclerView")
        }

    }
}
