package com.wednesday.feature_search.presentation

import com.wednesday.core_presentation.base.intent.Intent
import com.wednesday.core_presentation.model.weather.UICity

sealed interface SearchScreenIntent : Intent {

    data class SearchCities(
        val city: String
    ) : SearchScreenIntent

    data class ToggleFavourite(
        val city: UICity
    ) : SearchScreenIntent

    object Back : SearchScreenIntent
}
