package com.wednesday.core_presentation.base.effect

import android.view.View
import com.wednesday.core_presentation.model.base.UIText
import com.wednesday.core_presentation.model.datetime.UIDate

interface Effect

data class ShowDatePickerEffect(
    val selectedDate: UIDate,
    val minDate: UIDate? = null,
    val maxDate: UIDate? = null,
    val onDateSelected: (UIDate) -> Unit
) : Effect

data class ShowSnackbarEffect(
    val message: UIText,
    val action: UIText? = null,
    val onActionClick: (View) -> Unit = {}
) : Effect

object HideKeyboardEffect : Effect
