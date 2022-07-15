package com.wednesday.core_database.model.geoCoding

import androidx.room.Entity

@Entity(tableName = "favorite_locations", primaryKeys = ["lat", "lon"])
data class LocalLocation(
    val country: String,
    val lat: Double,
    val lon: Double,
    val name: String,
    val state: String?
)
