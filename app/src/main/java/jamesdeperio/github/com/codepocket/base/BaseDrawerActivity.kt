package jamesdeperio.github.com.codepocket.base

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder
import jamesdeperio.github.com.codepocket.R

/**
 * Created by jamesdeperio on 6/25/2017
 *  jamesdeperio.github.com.codepocket.base
 */
abstract class BaseDrawerActivity : AppCompatActivity(), BaseContract.Drawer,  BaseContract.Common {
    private var unbinder: Unbinder? = null
    var drawerLayout: DrawerLayout? = null
    var navigationView: NavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initContentView())
        unbinder = ButterKnife.bind(this)
        setSupportActionBar(initSupportingActionBar())
        drawerLayout = initDrawerLayout()
        navigationView = initNavigationView()
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, initSupportingActionBar(), R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout!!.setDrawerListener(toggle)
        toggle.syncState()
        navigationView!!.setNavigationItemSelectedListener(this)
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
