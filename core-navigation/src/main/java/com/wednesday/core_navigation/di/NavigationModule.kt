package com.wednesday.core_navigation.di

import androidx.fragment.app.Fragment
import com.wednesday.core_navigation.base.BaseNavigator
import com.wednesday.core_navigation.base.BaseNavigatorImpl
import com.wednesday.core_navigation.home.HomeNavigator
import com.wednesday.core_navigation.home.HomeNavigatorImpl
import com.wednesday.core_navigation.search.SearchNavigator
import com.wednesday.core_navigation.search.SearchNavigatorImpl
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val navigationModule = module {

    factory<BaseNavigator> { (fragment: Fragment) -> BaseNavigatorImpl(fragment) }

    factory<SearchNavigator> { (fragment: Fragment) ->
        SearchNavigatorImpl(
            get {
                parametersOf(
                    fragment
                )
            }
        )
    }
    factory<HomeNavigator> { (fragment: Fragment) ->
        HomeNavigatorImpl(
            get {
                parametersOf(
                    fragment
                )
            }
        )
    }
}
