package com.wednesday.core_presentation.model.weather

import com.wednesday.core_presentation.model.base.UIListItemBase
import com.wednesday.core_presentation.model.base.UIText
import kotlinx.parcelize.Parcelize

@Parcelize
data class UICity(
    val cityId: Int,
    val title: String,
    val state: String?,
    val displayTitle: UIText,
    val locationType: String,
    val displayLocationType: UIText,
    val latitude: String,
    val isFavourite: Boolean
) : UIListItemBase(id = "UICity $cityId")
