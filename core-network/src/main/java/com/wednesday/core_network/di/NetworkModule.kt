package com.wednesday.core_network.di

import com.wednesday.core_network.OpenWeatherRemoteService
import com.wednesday.core_network.interceptors.OpenWeatherApiKeyInterceptor
import com.wednesday.core_network.retrofit.getOpenWeatherRetrofit
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    // Retrofit
    factory { OpenWeatherApiKeyInterceptor() }

    single { getOpenWeatherRetrofit(get(), get<OpenWeatherApiKeyInterceptor>()) }

    // OpenWeather
    single { getWeatherRemoteService(get()) }


}

fun getWeatherRemoteService(retrofit: Retrofit): OpenWeatherRemoteService {
    return retrofit.create(OpenWeatherRemoteService::class.java)
}