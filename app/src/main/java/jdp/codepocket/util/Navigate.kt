package jdp.codepocket.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import jdp.codepocket.R
import java.lang.ref.WeakReference

/**
 * Created by jamesdeperio on 7/15/2017
 *  jamesdeperio.github.com.codepocket.util
 */
object Navigate {
    private var fromFragment:WeakReference<Fragment>? = null
    private var fromActivity:WeakReference<AppCompatActivity>? = null
    private var toFragment:WeakReference<Fragment>? = null
    private var toAnimEnter:Int = R.anim.h_fragment_pop_enter
    private var toAnimExit:Int =  R.anim.h_fragment_pop_exit
    private var fromAnimEnter:Int = R.anim.h_fragment_enter
    private var fromAnimExit:Int =R.anim.h_fragment_exit

    private var isBackstackEnabled:Boolean = false
    private var isAnimationEnabled:Boolean = false
    private var layoutID:Int = 0

    fun change(layoutID: Int): Navigate {
        Navigate.layoutID =layoutID
        return this
    }

    fun withBackStack(value:Boolean): Navigate {
        isBackstackEnabled =value
        isAnimationEnabled =true
        return this
    }

    fun from(currentClass: Any): Navigate {
        if(currentClass is Fragment) fromFragment = WeakReference(currentClass)
        else if (currentClass is AppCompatActivity) fromActivity =WeakReference(currentClass)
        isAnimationEnabled =false
        return this
    }

    fun to(currentClass: Fragment): Navigate {
         toFragment = WeakReference(currentClass)
        isAnimationEnabled =false
        return this
    }

    fun from(currentClass: Fragment, fromAnimEnter:Int,fromAnimExit: Int): Navigate {
        fromFragment = WeakReference(currentClass)
        Navigate.fromAnimEnter =fromAnimEnter
        Navigate.fromAnimExit =fromAnimExit
        isAnimationEnabled =true
        return this
    }

    fun to(currentClass: Fragment, toAnimEnter: Int,toAnimExit: Int): Navigate {
        toFragment = WeakReference(currentClass)
        Navigate.toAnimEnter =toAnimEnter
        Navigate.toAnimExit =toAnimExit
        isAnimationEnabled =true
        return this
    }

    fun commit(): Navigate {
        if (fromActivity !=null && toFragment !=null) changeFragment(fromActivity!!.get()!!.supportFragmentManager)
        else if (toFragment !=null) changeFragment(fromFragment!!.get()!!.fragmentManager!!)
        else throw IllegalStateException("WRONG SEQUENCE COMMIT!!")
        unRegister()
        return this
    }
    fun commitAllowingStateLoss(): Navigate {
        if (fromActivity !=null && toFragment !=null) changeFragmentWithStateLoss(fromActivity!!.get()!!.supportFragmentManager)
        else if (toFragment !=null) changeFragmentWithStateLoss(fromFragment!!.get()!!.fragmentManager!!)
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
        fromActivity = null
        toFragment = null
        layoutID = 1
    }
}