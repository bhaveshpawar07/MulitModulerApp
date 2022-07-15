package com.wednesday.core_database.model.currentWeather

import androidx.annotation.Keep

@Keep
data class LocalCurrentWeatherWind(
    val deg: Int,
    val speed: Double
)
