package com.wednesday.core_navigation.search

import com.wednesday.core_navigation.base.BaseNavigator


class SearchNavigatorImpl(
    private val baseNavigator: BaseNavigator
) : SearchNavigator {

    override fun back() {
        baseNavigator.back()
    }
}
