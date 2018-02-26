package jamesdeperio.github.com.codepocket.view

import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import jamesdeperio.github.com.codepocket.R
import jamesdeperio.github.com.codepocket.base.BaseContract

/**
* Created by jamesdeperio on 02/23/2018.
**/


abstract class DrawerView(private val appCompatActivity: AppCompatActivity) : BaseContract.Drawer {
    var drawerLayout: DrawerLayout? = null
    var navigationView: NavigationView? = null

    init { onStart() }


    private fun onStart() {
        appCompatActivity.setSupportActionBar(initSupportingActionBar())
        drawerLayout = initDrawerLayout()
        navigationView = initNavigationView()
        val toggle = ActionBarDrawerToggle(
                appCompatActivity, drawerLayout, initSupportingActionBar(), R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout!!.addDrawerListener(toggle)
        toggle.syncState()
        navigationView!!.setNavigationItemSelectedListener(appCompatActivity as NavigationView.OnNavigationItemSelectedListener)
    }

}
