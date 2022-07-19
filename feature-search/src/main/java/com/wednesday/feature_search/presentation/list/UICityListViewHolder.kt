package com.wednesday.feature_search.presentation.list

import androidx.core.content.ContextCompat
import kotlinx.coroutines.channels.Channel
import com.wednesday.core_common.databinding.CityItemListBinding
import com.wednesday.core_presentation.base.list.viewholder.BaseViewHolder
import com.wednesday.core_presentation.model.weather.UICity
import com.wednesday.core_common.R
import com.wednesday.core_presentation.base.intent.Intent
import com.wednesday.feature_search.presentation.SearchScreenIntent


class UICityListViewHolder(private val binding: CityItemListBinding) :
    BaseViewHolder<UICity>(binding) {

    override fun onSetupIntents(intentChannel: Channel<Intent>) = with(binding) {
        imageViewFavourite.setOnClickListener {
            val value = SearchScreenIntent.ToggleFavourite(item)
            intentChannel.trySend(value)
        }
    }

    override fun onBindInternal() = binding.run {

        compareAndSet({ title to state }) {
            val title = it.first + if (it.second != null) ", ${it.second}" else ""
            cityTextViewListItem.text = title
        }

        compareAndSet({ latitude }) {
            latitudeTextViewListItem.text = it
        }

        compareAndSet({ isFavourite }) {
            val drawable = ContextCompat.getDrawable(
                root.context,
                if (it) R.drawable.ic_favorite else R.drawable.ic_favorite_border
            )
            imageViewFavourite.setImageDrawable(drawable)
        }
    }
}
