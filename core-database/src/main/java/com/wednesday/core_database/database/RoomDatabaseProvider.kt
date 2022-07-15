package com.wednesday.core_database.database

import android.content.Context
import androidx.room.Room.databaseBuilder

fun getRoomDatabase(applicationContext: Context): AndroidTemplateDatabase {
    return databaseBuilder(
        applicationContext,
        AndroidTemplateDatabase::class.java,
        "android_template_room_database"
    ).build()
}
