package com.wednesday.core_presentation.base.extensions

import android.view.View
import android.widget.TextView
import com.wednesday.core_presentation.model.base.UIText

internal fun View.show() {
    visibility = View.VISIBLE
}

internal fun View.hide() {
    visibility = View.GONE
}

internal fun View.invisible() {
    visibility = View.INVISIBLE
}

internal fun View.setVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

fun TextView.setUIText(uiText: UIText) {
    text = uiText.asString()
}
