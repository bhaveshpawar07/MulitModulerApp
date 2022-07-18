package com.wednesday.core_presentation.base.list.viewholder

import com.wednesday.core_common.databinding.ItemListTextBinding
import com.wednesday.core_presentation.base.extensions.asString
import com.wednesday.core_presentation.base.intent.Intent
import com.wednesday.core_presentation.base.list.UIListUIText
import kotlinx.coroutines.channels.Channel

class UIListUITextViewHolder(private val binding: ItemListTextBinding) :
    BaseViewHolder<UIListUIText>(binding) {

    override fun onSetupIntents(intentChannel: Channel<Intent>) {
        /* no-op */
    }

    override fun onBindInternal() = binding.run {
        compareAndSet({ text }) {
            textViewListItem.text = it.asString()
        }
    }
}
