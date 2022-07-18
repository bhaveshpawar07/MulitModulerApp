package com.wednesday.core_presentation.model.datetime

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UIDate(
    val dayOfMonth: Int, // from 1 to 31
    val month: Int, // from 0 to 11
    val year: Int,
    val timeAsLong: Long
) : Parcelable
