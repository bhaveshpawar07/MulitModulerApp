package com.wednesday.core_network

import com.wednesday.core_network.models.currentWeather.RemoteCurrentWeather
import com.wednesday.core_network.models.geoCoding.RemoteLocation
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherRemoteService {

    @GET("geo/1.0/direct")
    suspend fun geocodingSearch(
        @Query("q") searchTerm: String,
        @Query("limit") limit: Int = 5
    ): List<RemoteLocation>

    @GET("data/2.5/weather?unit" +
            "s=metric")
    suspend fun currentWeather(
        @Query("q") cityAndState: String,
    ): RemoteCurrentWeather
}