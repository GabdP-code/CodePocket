package jdp.codepocket.util

import android.support.v7.widget.RecyclerView
import android.view.animation.OvershootInterpolator
import jp.wasabeef.recyclerview.adapters.*
import java.lang.ref.WeakReference

/**
 * Created by jamesdeperio on 6/25/2017
 *  jamesdeperio.github.com.codepocket.util
 */
object RecyclerAnim {
    val SCALE_IN: Byte = 0
    val ALPHA_IN: Byte = 1
    val SLIDE_RIGHT: Byte = 2
    val SLIDE_LEFT: Byte = 3
    val SLIDE_BOTTOM: Byte = 4
    private var anim: Byte = 5
    private var recyclerView: WeakReference<RecyclerView>? = null
    private var layoutManager: RecyclerView.LayoutManager?=null
    private var pocketAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>?=null
    fun setAnim(anim: Byte): RecyclerAnim {
        this.anim = anim
        return this
    }
    fun create(): RecyclerAnim {
        val adapter: AnimationAdapter = when (anim) {
            ALPHA_IN -> AlphaInAnimationAdapter(pocketAdapter)
            SCALE_IN -> ScaleInAnimationAdapter(pocketAdapter)
            SLIDE_BOTTOM -> SlideInBottomAnimationAdapter(pocketAdapter)
            SLIDE_LEFT -> SlideInLeftAnimationAdapter(pocketAdapter)
            SLIDE_RIGHT -> SlideInRightAnimationAdapter(pocketAdapter)
            else -> SlideInLeftAnimationAdapter(pocketAdapter)
        }
        if(anim!= 5.toByte()){
            adapter.setDuration(1000)
            adapter.setFirstOnly(false)
            adapter.setInterpolator(OvershootInterpolator())
        }
        recyclerView!!.get()!!.adapter = adapter
        recyclerView!!.get()!!.layoutManager = layoutManager
        return this
    }
    fun setRecyclerView(recyclerView:RecyclerView): RecyclerAnim {
        this.recyclerView = WeakReference(recyclerView)
        return this
    }
    fun setAdapter(pocketAdapter:  RecyclerView.Adapter<RecyclerView.ViewHolder>): RecyclerAnim {
        this.pocketAdapter = pocketAdapter
        return this
    }
    fun setLayoutManager(layoutManager: RecyclerView.LayoutManager): RecyclerAnim {
        this.layoutManager = layoutManager
        return this
    }
}