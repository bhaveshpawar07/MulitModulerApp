package com.wednesday.feature_weather.presentation.list

import android.view.ViewGroup
import com.wednesday.core_common.databinding.ItemDayWeatherHeadingBinding
import com.wednesday.core_presentation.base.list.renderer.ListItemRenderer
import com.wednesday.core_presentation.base.list.viewholder.BaseViewHolder
import com.wednesday.core_presentation.model.weather.UIDayWeatherHeading

class UIDayWeatherHeadingRenderer : ListItemRenderer<UIDayWeatherHeading>() {

    override fun getViewHolder(viewGroup: ViewGroup): BaseViewHolder<UIDayWeatherHeading> {
        return UIDayWeatherHeadingViewHolder(
            binding = viewGroup bind ItemDayWeatherHeadingBinding::inflate
        )
    }
}
