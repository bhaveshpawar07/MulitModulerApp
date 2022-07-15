package com.wednesday.core_network.models.currentWeather

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class RemoteCurrentWeatherSys(
    @SerialName("country")
    val country: String,
    @SerialName("sunrise")
    val sunrise: Int,
    @SerialName("sunset")
    val sunset: Int,
)
