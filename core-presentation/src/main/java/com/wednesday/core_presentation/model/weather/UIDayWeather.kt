package com.wednesday.core_presentation.model.weather

import com.wednesday.core_presentation.model.base.UIListItemBase
import com.wednesday.core_presentation.model.base.UIText
import kotlinx.parcelize.Parcelize

@Parcelize
data class UIDayWeather(
    val cityId: Int,
    val currentTemp: UIText,
    val minMaxTemp: UIText,
    val date: UIText
) : UIListItemBase(id = "UICity $cityId $date")
