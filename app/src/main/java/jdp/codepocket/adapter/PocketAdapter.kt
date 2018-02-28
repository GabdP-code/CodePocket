package jdp.codepocket.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by jamesdeperio on 7/7/2017
 *  jamesdeperio.github.com.codepocket.adapter
 */
abstract class PocketAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), PocketAdapterContract.Adapter {
    private val pocketViewHolderList = ArrayList<PocketViewHolder>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        for (position in 0 until  pocketViewHolderList.size)
            if (viewType == position) {
                pocketViewHolderList[position]
                        .setView(LayoutInflater.from(parent.context).inflate(pocketViewHolderList[position].initContentView(), parent, false))
                return pocketViewHolderList[position].viewHolder
            }
        return null
    }

    private var selectedLayout: Int = 0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)
            = pocketViewHolderList[selectedLayout].onCreateView(holder.itemView,position)
    override fun getItemCount(): Int = getDataCount()
    override fun getItemViewType(position: Int): Int {
        selectedLayout= viewTypeCondition(position)
        return  selectedLayout
    }
    override fun viewTypeCondition(position: Int): Int = 0

    override fun addViewHolder(viewHolder: PocketViewHolder) {
        pocketViewHolderList.add(viewHolder)
    }


}

