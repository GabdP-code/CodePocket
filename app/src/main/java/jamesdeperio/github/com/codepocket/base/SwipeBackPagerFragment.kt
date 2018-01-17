package jamesdeperio.github.com.codepocket.base

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.eftimoff.viewpagertransformers.DefaultTransformer
import me.yokeyword.swipebackfragment.SwipeBackFragment
import java.util.*

/**
 * Created by jamesdeperio on 6/25/2017
 *  jamesdeperio.github.com.codepocket.base
 */
abstract class SwipeBackPagerFragment : SwipeBackFragment(),
        ViewPager.OnPageChangeListener,
        TabLayout.OnTabSelectedListener,
        BaseContract.Common,
        BaseContract.ViewPager {
    private var unbinder: Unbinder? = null
    var rootView: View? = null
    var viewPager: ViewPager? = null
    private var pocketViewPagerAdapter: PocketViewPagerAdapter?=null
    private var titleList: MutableList<String>?=null
    private var fragmentList: MutableList<Fragment>? = null
    fun addPage(title: String, fragment: Fragment) {
        titleList!!.add(title)
        fragmentList!!.add(fragment)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(initContentView(), container, false)
        unbinder=ButterKnife.bind(this,rootView!!)
        titleList = ArrayList()
        fragmentList = ArrayList()
        setupPage()
        viewPager = initViewPager()
        pocketViewPagerAdapter = PocketViewPagerAdapter(childFragmentManager,fragmentList,titleList)
        viewPager!!.adapter = pocketViewPagerAdapter
        if(initTabLayout()!=null) initTabLayout()!!.setupWithViewPager(viewPager)
        viewPager!!.setPageTransformer(true, initPageTransformer())
        viewPager!!.addOnPageChangeListener(this)
        initialization(savedInstanceState)
        return attachToSwipeBack(rootView)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoadEvent(savedInstanceState)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        unbinder!!.unbind()
    }
    override fun initPageTransformer(): ViewPager.PageTransformer = DefaultTransformer()
    override fun initTabLayout(): TabLayout? = null
    override fun onTabSelected(tab: TabLayout.Tab) {}
    override fun onTabUnselected(tab: TabLayout.Tab) {}
    override fun onTabReselected(tab: TabLayout.Tab) {}
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    override fun onPageSelected(position: Int) {}
    override fun onPageScrollStateChanged(state: Int) {}
}

