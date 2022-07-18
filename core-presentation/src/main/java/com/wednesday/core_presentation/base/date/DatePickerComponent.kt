package com.wednesday.core_presentation.base.date

import android.app.DatePickerDialog
import android.view.View
import androidx.fragment.app.Fragment
import com.wednesday.core_presentation.base.component.Component
import com.wednesday.core_presentation.base.effect.ShowDatePickerEffect
import com.wednesday.core_presentation.model.datetime.UIDate

class DatePickerComponent(
    private val fragment: Fragment
) : Component<ShowDatePickerEffect>() {

    override fun bindInternal(view: View) = Unit

    override fun setData(data: ShowDatePickerEffect) {
        val selectedDate = data.selectedDate
        val dialog = DatePickerDialog(
            fragment.requireContext(),
            { _, year, monthOfYear, dayOfMonth ->
                val selectedUIDate = UIDate(
                    dayOfMonth = dayOfMonth,
                    month = monthOfYear,
                    year = year,
                    timeAsLong = 0
                )
                data.onDateSelected(selectedUIDate)
            },
            selectedDate.year,
            selectedDate.month,
            selectedDate.dayOfMonth
        )
        data.minDate?.let {
            dialog.datePicker.minDate = it.timeAsLong
        }
        data.maxDate?.let {
            dialog.datePicker.maxDate = it.timeAsLong
        }
        dialog.show()
    }

    override fun unbindInternal() = Unit
}
