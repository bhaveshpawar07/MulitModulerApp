package com.wednesday.core_presentation.base.list.renderer

import android.view.ViewGroup
import com.wednesday.core_common.databinding.ItemListTextBinding
import com.wednesday.template.presentation.base.list.UIListText
import com.wednesday.template.presentation.base.list.viewholder.BaseViewHolder
import com.wednesday.template.presentation.base.list.viewholder.UIListTextViewHolder

class UIListTextRenderer : ListItemRenderer<UIListText>() {

    override fun getViewHolder(viewGroup: ViewGroup): BaseViewHolder<UIListText> {
        return UIListTextViewHolder(
            binding = viewGroup bind ItemListTextBinding::inflate
        )
    }
}
