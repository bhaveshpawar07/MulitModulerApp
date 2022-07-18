package com.wednesday.core_presentation.model.base

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.wednesday.core_presentation.model.base.UIText
import kotlinx.parcelize.Parcelize

@Parcelize
data class UIToolbar(
    val title: UIText,
    val hasBackButton: Boolean,
    @DrawableRes
    val menuIcon: Int?,
    val menuButtonEnabled: Boolean = true
) : Parcelable
