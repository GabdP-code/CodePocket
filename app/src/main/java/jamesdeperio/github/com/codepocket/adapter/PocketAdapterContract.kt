package jamesdeperio.github.com.codepocket.adapter

import android.view.View

/**
 * Created by jamesdeperio on 7/7/2017
 *  jamesdeperio.github.com.codepocket.adapter
 */
internal interface PocketAdapterContract {
    interface Adapter {
        fun viewTypeCondition(position: Int): Int
        fun getDataCount() : Int
        fun addViewHolder(tag: String, viewHolder: PocketViewHolder)
    }

    interface Holder {
        fun initContentView(): Int
         fun onBindEvent(view: View, position: Int)
        fun setView(view: View)
        fun onCreateView(view: View, position: Int)
        fun getTag(): String
    }
}
