package com.firstaid.util.customview

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.firstaid.R

import java.util.*


class DatePickerDialogFragment(
    var previouslySelectedCalender: Calendar?,
    var isForDateOfBirth: Boolean,
    var listener: OnDateSetListener
) : DialogFragment(), OnDateSetListener {
    private val AGE_LIMIT = -18

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c: Calendar = Calendar.getInstance()
        if (isForDateOfBirth) {
            c.add(Calendar.YEAR, AGE_LIMIT);
        }
        var year: Int = c.get(Calendar.YEAR)
        var month: Int = c.get(Calendar.MONTH)
        var day: Int = c.get(Calendar.DAY_OF_MONTH)
        if (previouslySelectedCalender != null) {
            year = previouslySelectedCalender?.get(Calendar.YEAR)!!
            month = previouslySelectedCalender?.get(Calendar.MONTH)!!
            day = previouslySelectedCalender?.get(Calendar.DAY_OF_MONTH)!!
        }
        val dialog =
            DatePickerDialog(requireContext(), R.style.DatePickerDialog, this, year, month, day)
        if (isForDateOfBirth) {
            dialog.datePicker.maxDate = c.getTime().getTime()
        } else {
            dialog.datePicker.minDate = c.getTime().getTime()
        }
        dialog.setTitle("")
        return dialog
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener.onDateSet(view, year, month, dayOfMonth);
    }
}