package com.wednesday.core_presentation.base.list

import com.wednesday.core_presentation.model.base.UIListItemBase
import kotlinx.parcelize.Parcelize

@Parcelize
data class UIListText(
    val text: String
) : UIListItemBase(id = "UIListText $text")
