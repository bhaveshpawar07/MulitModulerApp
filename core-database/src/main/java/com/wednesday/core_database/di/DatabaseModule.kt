package com.wednesday.core_database.di

import com.wednesday.core_database.OpenWeatherLocalService
import com.wednesday.core_database.dao.OpenWeatherLocalServiceImpl
import com.wednesday.core_database.database.AndroidTemplateDatabase
import com.wednesday.core_database.database.getRoomDatabase
import org.koin.dsl.module

val databaseModule = module {
    // Room
    single { getRoomDatabase(get()) }

    //OpenWeather
    single<OpenWeatherLocalService> { getWeatherLocalService(get()) }

}

fun getWeatherLocalService(database: AndroidTemplateDatabase): OpenWeatherLocalServiceImpl {
    return database.databaseDao()
}