package com.wednesday.core_presentation.base.list

import com.wednesday.core_presentation.model.base.UIListItemBase

interface BaseAdapter {

    val items: List<UIListItemBase>

    fun updateData(newItems: List<UIListItemBase>)
}
