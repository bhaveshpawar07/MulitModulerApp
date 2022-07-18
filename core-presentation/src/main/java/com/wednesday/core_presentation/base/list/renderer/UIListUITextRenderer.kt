package com.wednesday.core_presentation.base.list.renderer

import android.view.ViewGroup
import com.wednesday.core_common.databinding.ItemListTextBinding
import com.wednesday.core_presentation.base.list.UIListUIText
import com.wednesday.core_presentation.base.list.viewholder.BaseViewHolder
import com.wednesday.core_presentation.base.list.viewholder.UIListUITextViewHolder

class UIListUITextRenderer : ListItemRenderer<UIListUIText>() {

    override fun getViewHolder(viewGroup: ViewGroup): BaseViewHolder<UIListUIText> {
        return UIListUITextViewHolder(
            binding = viewGroup bind ItemListTextBinding::inflate
        )
    }
}
