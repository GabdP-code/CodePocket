package jamesdeperio.github.com.codepocket.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder

/**
 * Created by jamesdeperio on 6/25/2017
 *  jamesdeperio.github.com.codepocket.base
 */

abstract class BaseFragment : Fragment(),
        BaseContract.Common {
    private var unbinder: Unbinder? = null
    var rootView: View? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(initContentView(), container, false)
        unbinder = ButterKnife.bind(this, rootView!!)
        initialization(savedInstanceState)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoadEvent(savedInstanceState)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        unbinder!!.unbind()
    }
}
