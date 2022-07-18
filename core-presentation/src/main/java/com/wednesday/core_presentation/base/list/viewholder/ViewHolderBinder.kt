package com.wednesday.core_presentation.base.list.viewholder

import com.wednesday.core_presentation.model.base.UIListItemBase

interface ViewHolderBinder<T : UIListItemBase> {

    fun onBind(current: T)
}
