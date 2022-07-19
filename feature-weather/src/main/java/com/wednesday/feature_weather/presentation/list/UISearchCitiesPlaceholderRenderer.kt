package com.wednesday.feature_weather.presentation.list

import android.view.ViewGroup
import com.wednesday.core_common.databinding.ItemSearchCityPlaceholderBinding
import com.wednesday.core_presentation.base.list.renderer.ListItemRenderer
import com.wednesday.core_presentation.base.list.viewholder.BaseViewHolder
import com.wednesday.core_presentation.model.weather.UISearchCitiesPlaceholder

class UISearchCitiesPlaceholderRenderer : ListItemRenderer<UISearchCitiesPlaceholder>() {

    override fun getViewHolder(viewGroup: ViewGroup): BaseViewHolder<UISearchCitiesPlaceholder> {
        return UISearchCitiesPlaceholderViewHolder(
            binding = viewGroup bind ItemSearchCityPlaceholderBinding::inflate
        )
    }
}
