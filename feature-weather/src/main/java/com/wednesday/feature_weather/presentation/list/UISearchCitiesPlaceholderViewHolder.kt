package com.wednesday.feature_weather.presentation.list

import com.wednesday.core_common.databinding.ItemSearchCityPlaceholderBinding
import com.wednesday.core_presentation.base.extensions.setUIText
import com.wednesday.core_presentation.base.intent.Intent
import com.wednesday.core_presentation.base.list.viewholder.BaseViewHolder
import com.wednesday.core_presentation.model.weather.UISearchCitiesPlaceholder
import com.wednesday.feature_weather.presentation.HomeScreenIntent
import kotlinx.coroutines.channels.Channel

class UISearchCitiesPlaceholderViewHolder(private val binding: ItemSearchCityPlaceholderBinding) :
    BaseViewHolder<UISearchCitiesPlaceholder>(binding) {

    override fun onSetupIntents(intentChannel: Channel<Intent>) = binding.run {
        buttonSearch.setOnClickListener {
            intentChannel.trySend(HomeScreenIntent.Search)
        }
    }

    override fun onBindInternal() = binding.run {

        compareAndSet({ text }) {
            textViewPlaceholder.setUIText(it)
        }
    }
}
