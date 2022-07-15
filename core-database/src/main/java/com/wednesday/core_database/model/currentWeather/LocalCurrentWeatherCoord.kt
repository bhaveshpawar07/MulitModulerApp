package com.wednesday.core_database.model.currentWeather

import androidx.annotation.Keep

@Keep
data class LocalCurrentWeatherCoord(
    val lat: Double,
    val lon: Double
)
