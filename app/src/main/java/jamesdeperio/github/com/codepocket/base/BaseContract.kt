package jamesdeperio.github.com.codepocket.base

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.widget.DrawerLayout

/**
 * Created by jamesdeperio on 6/25/2017
 *  jamesdeperio.github.com.codepocket.base
 */
internal interface BaseContract {
    interface Common {
        fun initialization(savedInstanceState: Bundle?)
        fun onLoadEvent(savedInstanceState: Bundle?)

    }
    interface Activity{
        fun initSupportingActionBar(): android.support.v7.widget.Toolbar?
    }

    interface Fragment {
        fun setLayout(layout:Int)
    }

    interface ViewPager {
        fun initTabLayout(): TabLayout?
        fun initViewPager(): android.support.v4.view.ViewPager
        fun initPageTransformer(): android.support.v4.view.ViewPager.PageTransformer
        fun setupPage()
    }
    interface Drawer:NavigationView.OnNavigationItemSelectedListener {
        fun initDrawerLayout(): DrawerLayout
        fun initSupportingActionBar(): android.support.v7.widget.Toolbar
        fun initNavigationView(): NavigationView

    }

}
