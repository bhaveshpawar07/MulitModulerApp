package com.wednesday.feature_search.presentation

import com.wednesday.core_presentation.model.base.UIList
import com.wednesday.core_presentation.model.base.UIToolbar
import com.wednesday.core_presentation.model.screen.MainScreenState
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchScreenState(
    override val toolbar: UIToolbar,
    override val showLoading: Boolean,
    val searchList: UIList = UIList()
) : MainScreenState
