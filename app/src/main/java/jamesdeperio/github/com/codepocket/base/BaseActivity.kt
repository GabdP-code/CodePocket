package jamesdeperio.github.com.codepocket.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.ButterKnife
import butterknife.Unbinder

/**
* Created by jamesdeperio on 6/25/2017
*  jamesdeperio.github.com.codepocket.base
*/

@Suppress("SENSELESS_COMPARISON")
abstract class BaseActivity : AppCompatActivity(),
        BaseContract.Activity,
        BaseContract.Common {
    private var unbinder: Unbinder? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initContentView())
        unbinder = ButterKnife.bind(this)
        if(initSupportingActionBar()!=null) setSupportActionBar(initSupportingActionBar())
        initialization(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        onLoadEvent(savedInstanceState)
    }
    override fun onDestroy() {
        super.onDestroy()
        unbinder!!.unbind()
    }

    override fun initSupportingActionBar(): Toolbar? = null
}
