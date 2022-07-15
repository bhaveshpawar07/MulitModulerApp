package com.wednesday.core_repository.di

import com.wednesday.core_common.mappers.weather.DomainCityMapper
import com.wednesday.core_common.mappers.weather.DomainCityMapperImpl
import com.wednesday.core_common.mappers.weather.LocalCityMapper
import com.wednesday.core_common.mappers.weather.LocalCityMapperImpl
import com.wednesday.core_common.mappers.weather.LocalWeatherMapper
import com.wednesday.core_common.mappers.weather.LocalWeatherMapperImpl
import com.wednesday.core_repository.mappers.weather.DomainWeatherMapper
import com.wednesday.core_repository.mappers.weather.DomainWeatherMapperImpl
import com.wednesday.core_repository.repository.date.DateRepoImpl
import com.wednesday.core_repository.repository.weather.WeatherRepositoryImpl
import com.wednesday.core_repository.repository.date.DateRepo
import com.wednesday.core_repository.repository.weather.WeatherRepository
import org.koin.dsl.module

val repositoryModule = module {
    // Date Time
    single<DateRepo> { DateRepoImpl() }

    //Weather mapper
    single<DomainCityMapper> { DomainCityMapperImpl() }

    single<LocalCityMapper> { LocalCityMapperImpl() }

    single<DomainWeatherMapper> { DomainWeatherMapperImpl() }

    single<LocalWeatherMapper> { LocalWeatherMapperImpl(get()) }

    //Weather
    single<WeatherRepository> {
        WeatherRepositoryImpl(get(), get(), get(), get(), get(), get(), get())
    }
}