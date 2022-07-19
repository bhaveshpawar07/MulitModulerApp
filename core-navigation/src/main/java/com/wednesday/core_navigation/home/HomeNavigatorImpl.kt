package com.wednesday.core_navigation.home

import android.util.Log
import com.wednesday.core_navigation.base.BaseNavigator
import com.wednesday.core_navigation.base.Screen

class HomeNavigatorImpl(
    private val baseNavigator: BaseNavigator
) : HomeNavigator {

    init {
        Log.d("HomeNavigatorImpl", "navViewModel init $this")
    }

    override fun navigateTo(screen: Screen) {
        baseNavigator.navigateTo(screen)
    }
}
