package com.wednesday.core_presentation.model.screen

import com.wednesday.core_presentation.model.base.UIToolbar

interface MainScreenState : ScreenState {
    val toolbar: UIToolbar
    val showLoading: Boolean
}
