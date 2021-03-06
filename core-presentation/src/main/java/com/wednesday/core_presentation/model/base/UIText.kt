package com.wednesday.core_presentation.model.base

import android.os.Parcelable
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class UIText(
    private val _blocks: MutableList<Block> = mutableListOf()
) : Parcelable {

    val blocks: List<Block>
        get() = _blocks

    sealed interface Block : Parcelable

    fun concat(block: Block): UIText {
        _blocks.add(block)
        return this
    }

    companion object {
        operator fun invoke(block: UIText.() -> Unit) = UIText().apply { block() }
    }

    fun UIText.block(text: String) {
        concat(Raw(text))
    }

    fun UIText.block(@StringRes resId: Int) {
        concat(Resource(resId))
    }

    fun UIText.block(
        text: String,
        arg1: String? = null,
        arg2: String? = null,
        arg3: String? = null
    ) {
        concat(RawFormatted(text, arg1, arg2, arg3))
    }

    fun UIText.block(
        @StringRes resId: Int,
        arg1: String? = null,
        arg2: String? = null,
        arg3: String? = null
    ) {
        concat(ResourceFormatted(resId, arg1, arg2, arg3))
    }
}
