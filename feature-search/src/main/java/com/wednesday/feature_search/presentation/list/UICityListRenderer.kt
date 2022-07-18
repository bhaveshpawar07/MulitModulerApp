package com.wednesday.feature_search.presentation.list

import android.view.ViewGroup
import com.wednesday.core_presentation.base.list.renderer.ListItemRenderer
import com.wednesday.core_presentation.base.list.viewholder.BaseViewHolder
import com.wednesday.core_presentation.model.weather.UICity
import com.wednesday.core_common.databinding.CityItemListBinding

class UICityListRenderer : ListItemRenderer<UICity>() {
    override fun getViewHolder(viewGroup: ViewGroup): BaseViewHolder<UICity> {
        return UICityListViewHolder(
            binding = viewGroup bind CityItemListBinding::inflate
        )
    }
}
