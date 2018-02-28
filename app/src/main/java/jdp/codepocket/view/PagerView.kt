package jdp.codepocket.view

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import com.eftimoff.viewpagertransformers.DefaultTransformer
import jdp.codepocket.base.BaseContract
import jdp.codepocket.base.PocketViewPagerAdapter

/**
* Created by jamesdeperio on 02/23/2018.
**/


abstract class PagerView(private val fragment: Fragment) : BaseContract.ViewPager {
    override fun initPageTransformer(): ViewPager.PageTransformer = DefaultTransformer()
    override fun initTabLayout(): TabLayout? = null
    private var viewPager: ViewPager? = null
    private var pocketViewPagerAdapter: PocketViewPagerAdapter?=null
    private var titleList: MutableList<String> = ArrayList()
    private var fragmentList: MutableList<Fragment> = ArrayList()

    init { onStart() }

    fun addPage(title: String, fragment: Fragment) {
        titleList.add(title)
        fragmentList.add(fragment)
    }
    private fun onStart() {
        viewPager = initViewPager()
        pocketViewPagerAdapter = PocketViewPagerAdapter(fragment.childFragmentManager,fragmentList,titleList)
        viewPager!!.adapter = pocketViewPagerAdapter
        if(initTabLayout()!=null) initTabLayout()!!.setupWithViewPager(viewPager)
        viewPager!!.setPageTransformer(true, initPageTransformer())
        viewPager!!.addOnPageChangeListener(fragment as ViewPager.OnPageChangeListener)
    }
}
