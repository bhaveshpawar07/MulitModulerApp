package com.wednesday.core_network.models.currentWeather

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class RemoteCurrentWeatherClouds(
    @SerialName("all")
    val all: Int
)
