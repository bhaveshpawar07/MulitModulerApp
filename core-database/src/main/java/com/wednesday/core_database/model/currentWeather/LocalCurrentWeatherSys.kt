package com.wednesday.core_database.model.currentWeather

import androidx.annotation.Keep

@Keep
data class LocalCurrentWeatherSys(
    val country: String,
    val sunrise: Int,
    val sunset: Int,
)
