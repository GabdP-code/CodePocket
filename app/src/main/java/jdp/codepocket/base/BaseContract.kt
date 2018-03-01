package jdp.codepocket.base

import android.os.Bundle

/**
 * Created by jamesdeperio on 6/25/2017
 *  jamesdeperio.github.com.codepocket.base
 */
internal interface BaseContract {
    interface Common {
        fun initialization(savedInstanceState: Bundle?)
        fun onLoadEvent(savedInstanceState: Bundle?)

    }

}
