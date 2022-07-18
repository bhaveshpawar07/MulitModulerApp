package com.wednesday.core_repository.mappers.weather

import com.wednesday.core_common.mappers.base.Mapper3
import com.wednesday.core_database.model.currentWeather.LocalCurrentWeather
import com.wednesday.core_database.model.currentWeather.LocalCurrentWeatherClouds
import com.wednesday.core_database.model.currentWeather.LocalCurrentWeatherCoord
import com.wednesday.core_database.model.currentWeather.LocalCurrentWeatherMain
import com.wednesday.core_database.model.currentWeather.LocalCurrentWeatherSys
import com.wednesday.core_database.model.currentWeather.LocalCurrentWeatherWeather
import com.wednesday.core_database.model.currentWeather.LocalCurrentWeatherWind
import com.wednesday.core_network.models.currentWeather.RemoteCurrentWeather
import com.wednesday.core_repository.repository.date.DateRepo
import timber.log.Timber

interface LocalWeatherMapper : Mapper3<RemoteCurrentWeather, Double, Double, LocalCurrentWeather>

class LocalWeatherMapperImpl(private val dateRepo: DateRepo) : LocalWeatherMapper {

    override fun map(from1: RemoteCurrentWeather, from2: Double, from3: Double): LocalCurrentWeather {
        Timber.tag(TAG).d("map() called with: from1 = $from1, from2 = $from2, from3 = $from3")

        val clouds = LocalCurrentWeatherClouds(
            all = from1.clouds.all
        )

        val coord = LocalCurrentWeatherCoord(
            lat = from2,
            lon = from3
        )

        val main = LocalCurrentWeatherMain(
            feelsLike = from1.main.feelsLike,
            humidity = from1.main.humidity,
            pressure = from1.main.pressure,
            temp = from1.main.temp,
            tempMax = from1.main.tempMax,
            tempMin = from1.main.tempMin
        )

        val sys = LocalCurrentWeatherSys(
            country = from1.sys.country,
            sunrise = from1.sys.sunrise,
            sunset = from1.sys.sunset,
        )

        val remoteWeather = from1.weather.firstOrNull()
        val weather = LocalCurrentWeatherWeather(
            description = remoteWeather?.description ?: "",
            icon = remoteWeather?.icon ?: "01d",
            id = remoteWeather?.id ?: UInt.MIN_VALUE.toInt(),
            main = remoteWeather?.main ?: ""
        )

        val wind = LocalCurrentWeatherWind(
            deg = from1.wind.deg,
            speed = from1.wind.speed
        )

        return LocalCurrentWeather(
            base = from1.base,
            cod = from1.cod,
            dt = from1.dt,
            id = from1.id,
            name = from1.name,
            timezone = from1.timezone,
            visibility = from1.visibility,
            updatedAt = dateRepo.mapDateTime(dateRepo.nowDateTime()),
            clouds = clouds,
            coord = coord,
            main = main,
            sys = sys,
            weather = weather,
            wind = wind
        )
    }

    companion object {
        private const val TAG = "LocalWeatherMapperImpl"
    }
}
