package com.wednesday.template.presentation.base.snackbar

import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.wednesday.core_common.R
import com.wednesday.core_presentation.base.component.Component
import com.wednesday.core_presentation.base.effect.ShowSnackbarEffect
import com.wednesday.core_presentation.base.extensions.asString

class SnackbarComponent(
    private val fragment: Fragment
) : Component<ShowSnackbarEffect>() {

    override fun bindInternal(view: View) = Unit

    override fun setData(data: ShowSnackbarEffect) {
        val rootView: View = fragment.requireActivity().run {
            findViewById(R.id.snackbarRoot) ?: window.decorView.rootView
        }

        Snackbar.make(
            rootView,
            data.message.asString(),
            Snackbar.LENGTH_SHORT
        ).apply {
            if (data.action != null) {
                setAction(data.action.asString(), data.onActionClick)
            }
        }.show()
    }

    override fun unbindInternal() = Unit
}
