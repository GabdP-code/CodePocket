package jamesdeperio.github.com.codepocket.base

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.yokeyword.swipebackfragment.SwipeBackFragment

/**
 * Created by jamesdeperio on 6/25/2017
 *  jamesdeperio.github.com.codepocket.base
 */
abstract class SwipeBackPagerFragment : SwipeBackFragment(),
        ViewPager.OnPageChangeListener,
        TabLayout.OnTabSelectedListener,
        BaseContract.Common,
        BaseContract.ViewPagerControl {

    var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    //    rootView = inflater.inflate(initContentView(), container, false)
        setupPage()
        initialization(savedInstanceState)
        return attachToSwipeBack(rootView)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoadEvent(savedInstanceState)
    }



    override fun onTabSelected(tab: TabLayout.Tab) {}
    override fun onTabUnselected(tab: TabLayout.Tab) {}
    override fun onTabReselected(tab: TabLayout.Tab) {}
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    override fun onPageSelected(position: Int) {}
    override fun onPageScrollStateChanged(state: Int) {}
}

