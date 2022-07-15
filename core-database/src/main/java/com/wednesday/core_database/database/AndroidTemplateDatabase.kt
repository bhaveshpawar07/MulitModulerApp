package com.wednesday.core_database.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wednesday.core_database.dao.OpenWeatherLocalServiceImpl
import com.wednesday.core_database.database.migration.autoMigrationSpec.Version1to2MigrationSpec
import com.wednesday.core_database.model.geoCoding.LocalLocation
import com.wednesday.core_database.utils.DateConverter
import com.wednesday.core_database.model.currentWeather.LocalCurrentWeather

@Database(
    entities = [LocalLocation::class, LocalCurrentWeather::class],
    version = 3,
    autoMigrations = [
        AutoMigration(
            from = 1,
            to = 2,
            spec = Version1to2MigrationSpec::class
        ),
        AutoMigration(from = 2, to = 3)
    ],
)
@TypeConverters(DateConverter::class)
abstract class AndroidTemplateDatabase : RoomDatabase() {
    abstract fun databaseDao(): OpenWeatherLocalServiceImpl
}
