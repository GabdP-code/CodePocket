package jdp.codepocket.builder

import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout

/**
* Created by Jamesdeperio on 28/02/2018.
*/

class CardBuilder {
    class Builder {
        var drawerLayout: DrawerLayout? = null
        var navigationView: NavigationView? = null
        fun build() {
        }

    }
    companion object {
        inline fun build( properties:Builder.() -> Unit) = Builder().apply(properties).build()
    }

}
