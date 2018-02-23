package jamesdeperio.github.com.codepocket.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
* Created by jamesdeperio on 6/25/2017
*  jamesdeperio.github.com.codepocket.base
*/

@Suppress("SENSELESS_COMPARISON")
abstract class BaseActivity : AppCompatActivity(),
        BaseContract.Common {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       initialization(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        onLoadEvent(savedInstanceState)
    }

}
