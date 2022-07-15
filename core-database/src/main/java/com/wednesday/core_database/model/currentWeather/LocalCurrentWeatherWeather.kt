package com.wednesday.core_database.model.currentWeather

import androidx.annotation.Keep

@Keep
data class LocalCurrentWeatherWeather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)
