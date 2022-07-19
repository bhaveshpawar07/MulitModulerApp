package com.wednesday.core_presentation.base.list

import androidx.lifecycle.ViewModel
import com.wednesday.core_common.R
import com.wednesday.core_presentation.model.base.UIListItemBase
import com.wednesday.core_presentation.base.intent.Intent
import com.wednesday.core_presentation.base.intent.IntentHandler
import com.wednesday.core_presentation.base.list.renderer.ListItemRenderer

 class ListComponent<T, I : Intent>(
    listViewModel: T,
    recyclerViewId: Int = R.id.recyclerView,
    callback: ListComponent<T, I>.() -> Unit,
) : BaseListComponent<T, I>(
    listViewModel,
    recyclerViewId
) where T : ViewModel, T : IntentHandler<I> {

    init {
        callback(this)
    }

    @Suppress("UNCHECKED_CAST")
    inline fun <reified T : UIListItemBase> addRenderer(renderer: ListItemRenderer<T>) {
        renderers.add(T::class to (renderer as ListItemRenderer<UIListItemBase>))
    }
}
