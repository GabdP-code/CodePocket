package jamesdeperio.github.com.codepocket.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.yokeyword.swipebackfragment.SwipeBackFragment

/**
 * Created by jamesdeperio on 6/25/2017
 *  jamesdeperio.github.com.codepocket.base
 */
abstract class SwipeBackBaseFragment : SwipeBackFragment(),
        BaseContract.Common {
    var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       // rootView = inflater.inflate(initContentView(), container, false)
        initialization(savedInstanceState)
        return attachToSwipeBack(rootView)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoadEvent(savedInstanceState)
    }

}
