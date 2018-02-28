package jdp.codepocket.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.yokeyword.swipebackfragment.SwipeBackFragment as Sw

/**
 * Created by jamesdeperio on 6/25/2017
 *  jamesdeperio.github.com.codepocket.base
 */
abstract class SwipeBackBaseFragment : Sw(),
        BaseContract.Common,
        BaseContract.Fragment{
    var rootView: View? = null
    var layoutRes : Int =0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       rootView = inflater.inflate(layoutRes, container, false)
        initialization(savedInstanceState)
        return attachToSwipeBack(rootView)
    }


    override fun setLayout(layout: Int): SwipeBackBaseFragment {
        layoutRes=layout
        return this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoadEvent(savedInstanceState)
    }

}
