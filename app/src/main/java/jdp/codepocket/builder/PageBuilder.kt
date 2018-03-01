package jdp.codepocket.builder

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import jdp.codepocket.base.PocketViewPagerAdapter

/**
* Created by Jamesdeperio on 28/02/2018.
*/

class PageBuilder(var string: String){
    class Builder {
        private lateinit var viewPager: ViewPager
        private lateinit var fragmentManager: FragmentManager
        private  val titleList : MutableList<String> = ArrayList()
        private  val fragmentList : MutableList<Fragment> = ArrayList()
        private var tabLayout :TabLayout? = null
        private var pageTransformer: ViewPager.PageTransformer ? = null
        fun setViewPager(viewPager: ViewPager) {
            this.viewPager=viewPager
        }
        fun setTabLayout(tabLayout: TabLayout) {
            this.tabLayout=tabLayout
        }
        fun setFragmentManager(fragmentManager: FragmentManager){
            this.fragmentManager=fragmentManager
        }
        fun setPageTransformer(pageTransformer: ViewPager.PageTransformer){
            this.pageTransformer=pageTransformer
        }

        fun build() {
            viewPager.adapter = PocketViewPagerAdapter(fragmentManager,fragmentList,titleList)
            if(tabLayout!=null)  tabLayout!!.setupWithViewPager(viewPager)
            viewPager.setPageTransformer(true, pageTransformer)
        }

        fun addPage(title : String, fragment: Fragment) {
            titleList.add(title)
            fragmentList.add(fragment)
        }
    }
    companion object {
        inline fun build( properties:Builder.() -> Unit)= Builder().apply(properties).build()
    }

}
