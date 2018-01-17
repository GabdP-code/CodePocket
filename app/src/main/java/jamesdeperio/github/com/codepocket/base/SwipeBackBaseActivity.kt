package jamesdeperio.github.com.codepocket.base

import android.os.Bundle
import android.os.PersistableBundle
import butterknife.ButterKnife
import butterknife.Unbinder
import me.yokeyword.swipebackfragment.SwipeBackActivity
/**
 * Created by jamesdeperio on 6/25/2017
 *  jamesdeperio.github.com.codepocket.base
 */
abstract class SwipeBackBaseActivity : SwipeBackActivity(),
        BaseContract.Common,
        BaseContract.Activity{
    private var unbinder: Unbinder? = null
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(initContentView())
        unbinder = ButterKnife.bind(this)
        setSupportActionBar(initSupportingActionBar())
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
}