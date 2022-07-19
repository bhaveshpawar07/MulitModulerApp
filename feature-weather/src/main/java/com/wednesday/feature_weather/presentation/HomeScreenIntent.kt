package com.wednesday.feature_weather.presentation

import com.wednesday.core_presentation.base.intent.Intent


sealed interface HomeScreenIntent : Intent {

    object Search : HomeScreenIntent

    object Loading : HomeScreenIntent
    object Loading2 : HomeScreenIntent
    object Loading3 : HomeScreenIntent
}
