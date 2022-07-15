package com.wednesday.core_navigation.base


interface BaseNavigator : Navigator {

    fun navigateTo(screen: Screen)

    fun back()
}
