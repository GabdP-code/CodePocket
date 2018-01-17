package jamesdeperio.github.com.codepocket.util

import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import org.jetbrains.annotations.Nullable
import java.lang.ref.WeakReference

/**
* Created by jamesdeperio on 7/15/2017
*  jamesdeperio.github.com.codepocket.util
*/

object CleanView {
    fun clearMemory(@Nullable view: WeakReference<View>?) {
        if (view?.get()?.background != null)
            view.get()?.background?.callback = null
        if (view?.get() is ViewGroup && view.get() !is AdapterView<*>) {
            for (i in 0 until (view.get() as ViewGroup).childCount)
                clearMemory(WeakReference((view.get() as ViewGroup).getChildAt(i)))
            (view.get() as ViewGroup).removeAllViews()
        }
    }
}
