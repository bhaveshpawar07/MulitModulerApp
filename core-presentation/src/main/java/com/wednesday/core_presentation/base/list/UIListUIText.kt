package com.wednesday.core_presentation.base.list

import com.wednesday.core_presentation.model.base.UIListItemBase
import com.wednesday.core_presentation.model.base.UIText
import kotlinx.parcelize.Parcelize

@Parcelize
data class UIListUIText(
    val text: UIText
) : UIListItemBase(id = "UIListUIText $text")
