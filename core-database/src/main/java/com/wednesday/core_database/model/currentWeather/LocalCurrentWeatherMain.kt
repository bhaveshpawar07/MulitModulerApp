package com.wednesday.core_database.model.currentWeather

import androidx.annotation.Keep

@Keep
data class LocalCurrentWeatherMain(
    val feelsLike: Double,
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    val tempMax: Double,
    val tempMin: Double
)
