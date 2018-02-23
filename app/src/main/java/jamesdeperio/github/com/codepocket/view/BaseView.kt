package jamesdeperio.github.com.codepocket.view

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import jamesdeperio.github.com.codepocket.base.BaseContract

/**
* Created by jamesdeperio on 02/23/2018.
**/


abstract class BaseView(private val activity: AppCompatActivity) : BaseContract.Activity {
    override fun initSupportingActionBar(): Toolbar?  = null
    init { onStart() }

    private fun onStart() {
        if(initSupportingActionBar()!=null) activity.setSupportActionBar(initSupportingActionBar())
    }
}
