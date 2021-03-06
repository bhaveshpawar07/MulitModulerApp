package com.wednesday.core_presentation.base.list.viewholder

import com.wednesday.core_common.databinding.ItemListTextBinding
import com.wednesday.core_presentation.base.intent.Intent
import com.wednesday.core_presentation.base.list.UIListText
import kotlinx.coroutines.channels.Channel

class UIListTextViewHolder(private val binding: ItemListTextBinding) :
    BaseViewHolder<UIListText>(binding) {

    override fun onSetupIntents(intentChannel: Channel<Intent>) {
        /* no-op */
    }

    override fun onBindInternal() = binding.run {
        compareAndSet({ text }) {
            textViewListItem.text = it
        }
    }
}
