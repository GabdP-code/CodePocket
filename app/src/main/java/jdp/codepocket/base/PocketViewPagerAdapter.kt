package jdp.codepocket.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter



/**
 * Created by jamesdeperio on 6/25/2017
 *  jamesdeperio.github.com.codepocket.base
 */
class PocketViewPagerAdapter(fm: FragmentManager, private var fragmentList: MutableList<Fragment>?, private var titleList: MutableList<String>?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        var x = 0
        fragmentList!!.forEach {
            if (x == position) return it
            x++
        }
        return null
    }
    override fun getCount(): Int = titleList!!.size
    override fun getPageTitle(position: Int): CharSequence? {
        var x = 0
        titleList!!.forEach {
            if (x == position) return it
            x++
        }
        return null
    }

}