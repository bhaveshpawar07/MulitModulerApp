package com.wednesday.core_navigation.home

import com.wednesday.core_navigation.base.Navigator
import com.wednesday.core_navigation.base.Screen

interface HomeNavigator : Navigator {

    fun navigateTo(screen: Screen)
}
