package jdp.codepocket.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import jdp.codepocket.R
import java.lang.ref.WeakReference

/**
 * Created by jamesdeperio on 7/15/2017
 *  jamesdeperio.github.com.codepocket.util
 */
object Navigate {
    private var fromFragment:WeakReference<Fragment>? = null
    // private var fromActivity:WeakReference<AppCompatActivity>? = null
    private var fragmentManager:WeakReference<FragmentManager>? = null
    private var toFragment:WeakReference<Fragment>? = null
    private var toAnimEnter:Int = R.anim.h_fragment_pop_enter
    private var toAnimExit:Int =  R.anim.h_fragment_pop_exit
    private var fromAnimEnter:Int = R.anim.h_fragment_enter
    private var fromAnimExit:Int =R.anim.h_fragment_exit

    private var isBackstackEnabled:Boolean = false
    private var isAnimationEnabled:Boolean = false
    private var layoutID:Int = 0

    fun using (fragmentManager: FragmentManager): Navigate {
        this.fragmentManager=WeakReference(fragmentManager)
        return this
    }
    fun change(layoutID: Int): Navigate {
        Navigate.layoutID =layoutID
        return this
    }

    fun withBackStack(isBackstackEnabled:Boolean): Navigate {
        this.isBackstackEnabled =isBackstackEnabled
        isAnimationEnabled =true
        return this
    }

    fun from(currentFragment:Fragment): Navigate {
        fromFragment = WeakReference(currentFragment)
   //     else if (currentClass is AppCompatActivity) fromActivity =WeakReference(currentClass)
        isAnimationEnabled =false
        return this
    }

    fun to(fragmentToChange: Fragment): Navigate {
         toFragment = WeakReference(fragmentToChange)
        isAnimationEnabled =false
        return this
    }

    fun from(currentFragment: Fragment, fromAnimEnter:Int,fromAnimExit: Int): Navigate {
        fromFragment = WeakReference(currentFragment)
        Navigate.fromAnimEnter =fromAnimEnter
        Navigate.fromAnimExit =fromAnimExit
        isAnimationEnabled =true
        return this
    }

    fun to(fragmentToChange: Fragment, toAnimEnter: Int,toAnimExit: Int): Navigate {
        toFragment = WeakReference(fragmentToChange)
        Navigate.toAnimEnter =toAnimEnter
        Navigate.toAnimExit =toAnimExit
        isAnimationEnabled =true
        return this
    }

    fun commit(): Navigate {
        if (toFragment !=null) changeFragment(fragmentManager!!.get()!!)
        else throw IllegalStateException("WRONG SEQUENCE COMMIT!!")
        unRegister()
        return this
    }
    fun commitAllowingStateLoss(): Navigate {
        if (toFragment !=null) changeFragmentWithStateLoss(fragmentManager!!.get()!!)
        else throw IllegalStateException("WRONG SEQUENCE COMMIT!!")
        unRegister()
        return this
    }

    private fun changeFragmentWithStateLoss(fragmentManager: FragmentManager) {
        if(fromFragment==null){
            if (isBackstackEnabled && isAnimationEnabled) {
                fragmentManager.beginTransaction()
                        .setCustomAnimations(fromAnimEnter, fromAnimExit, toAnimEnter, toAnimExit)
                        .add(layoutID, toFragment!!.get()!!, toFragment!!.javaClass.simpleName)
                        .addToBackStack(toFragment!!.javaClass.simpleName)
                        .commitAllowingStateLoss()
            } else if (isBackstackEnabled) {
                fragmentManager.beginTransaction()
                        .add(layoutID, toFragment!!.get()!!, toFragment!!.javaClass.simpleName)
                        .addToBackStack(toFragment!!.javaClass.simpleName)
                        .commitAllowingStateLoss()
            } else if(!isBackstackEnabled){
                fragmentManager.beginTransaction()
                        .replace(layoutID, toFragment!!.get()!!, toFragment!!.javaClass.simpleName)
                        .disallowAddToBackStack()
                        .commitAllowingStateLoss()
            }else throw IllegalStateException("WRONG SEQUENCE FRAGMENT!!")
        }else{
            if (isBackstackEnabled && isAnimationEnabled) {
                fragmentManager.beginTransaction()
                        .setCustomAnimations(fromAnimEnter, fromAnimExit, toAnimEnter, toAnimExit)
                        .add(layoutID, toFragment!!.get()!!, toFragment!!.javaClass.simpleName)
                        .hide(fromFragment!!.get()!!)
                        .addToBackStack(toFragment!!.javaClass.simpleName)
                        .commit()
            } else if (isBackstackEnabled) {
                fragmentManager.beginTransaction()
                        .add(layoutID, toFragment!!.get()!!, toFragment!!.javaClass.simpleName)
                        .hide(fromFragment!!.get()!!)
                        .addToBackStack(toFragment!!.javaClass.simpleName)
                        .commit()
            } else if(!isBackstackEnabled){
                fragmentManager.beginTransaction()
                        .replace(layoutID, toFragment!!.get()!!, toFragment!!.javaClass.simpleName)
                        .disallowAddToBackStack()
                        .commit()
            }else throw IllegalStateException("WRONG SEQUENCE FRAGMENT!!")
        }
    }
    private fun changeFragment(fragmentManager: FragmentManager) {
        if(fromFragment==null){
            if (isBackstackEnabled && isAnimationEnabled) {
                fragmentManager.beginTransaction()
                        .setCustomAnimations(fromAnimEnter, fromAnimExit, toAnimEnter, toAnimExit)
                        .add(layoutID, toFragment!!.get()!!, toFragment!!.javaClass.simpleName)
                        .addToBackStack(toFragment!!.javaClass.simpleName)
                        .commit()
            } else if (isBackstackEnabled) {
                fragmentManager.beginTransaction()
                        .add(layoutID, toFragment!!.get()!!, toFragment!!.javaClass.simpleName)
                        .addToBackStack(toFragment!!.javaClass.simpleName)
                        .commit()
            } else if(!isBackstackEnabled){
                fragmentManager.beginTransaction()
                        .replace(layoutID, toFragment!!.get()!!, toFragment!!.javaClass.simpleName)
                        .disallowAddToBackStack()
                        .commit()
            }else throw IllegalStateException("WRONG SEQUENCE FRAGMENT!!")
        }else{
            if (isBackstackEnabled && isAnimationEnabled) {
                fragmentManager.beginTransaction()
                        .setCustomAnimations(fromAnimEnter, fromAnimExit, toAnimEnter, toAnimExit)
                        .add(layoutID, toFragment!!.get()!!, toFragment!!.javaClass.simpleName)
                        .hide(fromFragment!!.get()!!)
                        .addToBackStack(toFragment!!.javaClass.simpleName)
                        .commit()
            } else if (isBackstackEnabled) {
                fragmentManager.beginTransaction()
                        .add(layoutID, toFragment!!.get()!!, toFragment!!.javaClass.simpleName)
                        .hide(fromFragment!!.get()!!)
                        .addToBackStack(toFragment!!.javaClass.simpleName)
                        .commit()
            } else if(!isBackstackEnabled){
                fragmentManager.beginTransaction()
                        .replace(layoutID, toFragment!!.get()!!, toFragment!!.javaClass.simpleName)
                        .disallowAddToBackStack()
                        .commit()
            }else throw IllegalStateException("WRONG SEQUENCE FRAGMENT!!")
        }
    }
    private fun unRegister() {
        fromFragment = null
        fragmentManager = null
        toFragment = null
        layoutID = 1
    }
}