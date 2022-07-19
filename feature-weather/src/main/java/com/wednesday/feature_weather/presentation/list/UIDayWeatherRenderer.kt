package com.wednesday.feature_weather.presentation.list

import android.view.ViewGroup
import com.wednesday.core_common.databinding.ItemDayWeatherBinding
import com.wednesday.core_presentation.base.list.renderer.ListItemRenderer
import com.wednesday.core_presentation.base.list.viewholder.BaseViewHolder
import com.wednesday.core_presentation.model.weather.UIDayWeather

class UIDayWeatherRenderer : ListItemRenderer<UIDayWeather>() {

    override fun getViewHolder(viewGroup: ViewGroup): BaseViewHolder<UIDayWeather> {
        return UIDayWeatherViewHolder(
            binding = viewGroup bind ItemDayWeatherBinding::inflate
        )
    }
}
