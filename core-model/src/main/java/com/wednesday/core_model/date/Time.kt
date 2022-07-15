package com.wednesday.core_model.date

data class Time(
    val hourOfDay: Int, // from 0 to 23
    val minute: Int, // from 0 to 59
    val second: Int, // from 0 to 59
    val millisecond: Int // from 0 to 999
)
