package com.wednesday.template.presentation.weather.home.list

import android.view.ViewGroup
import com.wednesday.core_presentation.base.list.renderer.ListItemRenderer
import com.wednesday.core_presentation.base.list.viewholder.BaseViewHolder
import com.wednesday.core_presentation.model.weather.UIWeather
import com.wednesday.core_common.databinding.ItemWeatherBinding
import com.wednesday.feature_weather.presentation.list.UIWeatherViewHolder

class UIWeatherRenderer : ListItemRenderer<UIWeather>() {
    override fun getViewHolder(viewGroup: ViewGroup): BaseViewHolder<UIWeather> {
        return UIWeatherViewHolder(
            binding = viewGroup bind ItemWeatherBinding::inflate
        )
    }
}
