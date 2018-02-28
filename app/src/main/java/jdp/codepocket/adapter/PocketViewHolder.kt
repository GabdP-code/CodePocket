package jdp.codepocket.adapter

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by jamesdeperio on 7/7/2017
 *  jamesdeperio.github.com.codepocket.adapter
 */
abstract class PocketViewHolder : PocketAdapterContract.Holder {
    lateinit var viewHolder: RecyclerView.ViewHolder
    private inner class Holder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView)
    lateinit var rootView:View
    override fun onCreateView(view: View, position: Int) {
        rootView=view
        onCreateViewHolder(view,position)
    }
    override fun setView(view: View) {
        viewHolder = Holder(view)
    }

}
