package com.wednesday.feature_weather.presentation

import com.wednesday.core_presentation.model.base.UIList
import com.wednesday.core_presentation.model.base.UIToolbar
import com.wednesday.core_presentation.model.screen.MainScreenState
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeScreenState(
    override val toolbar: UIToolbar,
    override val showLoading: Boolean,
    val items: UIList
) : MainScreenState
