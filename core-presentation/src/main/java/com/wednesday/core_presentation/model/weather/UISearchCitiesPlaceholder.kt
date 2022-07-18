package com.wednesday.core_presentation.model.weather

import com.wednesday.core_presentation.model.base.UIListItemBase
import com.wednesday.core_presentation.model.base.UIText
import kotlinx.parcelize.Parcelize

@Parcelize
data class UISearchCitiesPlaceholder(
    val text: UIText
) : UIListItemBase("UISearchCitiesPlaceholder")
