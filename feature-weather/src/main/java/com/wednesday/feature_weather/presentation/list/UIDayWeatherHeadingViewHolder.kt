package com.wednesday.feature_weather.presentation.list

import com.wednesday.core_common.databinding.ItemDayWeatherHeadingBinding
import com.wednesday.core_presentation.base.extensions.setUIText
import com.wednesday.core_presentation.base.intent.Intent
import com.wednesday.core_presentation.base.list.viewholder.BaseViewHolder
import com.wednesday.core_presentation.model.weather.UIDayWeatherHeading
import kotlinx.coroutines.channels.Channel

class UIDayWeatherHeadingViewHolder(
    private val binding: ItemDayWeatherHeadingBinding
) : BaseViewHolder<UIDayWeatherHeading>(binding) {

    override fun onSetupIntents(intentChannel: Channel<Intent>) = Unit

    override fun onBindInternal() {

        compareAndSet({ text }) {
            binding.textViewHeading.setUIText(it)
        }
    }
}
