package com.wednesday.feature_weather.presentation.list

import com.wednesday.core_common.databinding.ItemDayWeatherBinding
import com.wednesday.core_presentation.base.extensions.setUIText
import com.wednesday.core_presentation.base.intent.Intent
import com.wednesday.core_presentation.base.list.viewholder.BaseViewHolder
import com.wednesday.core_presentation.model.weather.UIDayWeather
import kotlinx.coroutines.channels.Channel

class UIDayWeatherViewHolder(private val binding: ItemDayWeatherBinding) : BaseViewHolder<UIDayWeather>(binding) {

    override fun onSetupIntents(intentChannel: Channel<Intent>) = Unit

    override fun onBindInternal() = binding.run {

        compareAndSet({ date }) {
            textViewDayWeatherDate.setUIText(it)
        }

        compareAndSet({ currentTemp }) {
            textViewDayWeatherTemp.setUIText(it)
        }
    }
}
