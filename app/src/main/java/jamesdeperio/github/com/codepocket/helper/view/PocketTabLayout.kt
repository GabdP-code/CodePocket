package jamesdeperio.github.com.codepocket.helper.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.TableLayout


/**
 * Created by jamesdeperio on 8/26/2017
 *  jamesdeperio.github.com.codepocket.view
 */

class PocketTabLayout : TableLayout {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        try {
            return super.onTouchEvent(ev)
        } catch (ex: IllegalArgumentException) {
            ex.printStackTrace()
        }

        return false
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        try {
            return super.onInterceptTouchEvent(ev)
        } catch (ex: IllegalArgumentException) {
            ex.printStackTrace()
        }

        return false
    }
}
