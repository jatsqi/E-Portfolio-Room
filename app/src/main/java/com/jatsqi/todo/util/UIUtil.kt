package com.jatsqi.todo.util

import android.graphics.Paint
import android.widget.TextView

fun TextView.setStrikeThruVisibility(visible: Boolean) {
    if (visible) {
        paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    } else {
        paintFlags = 0
    }
}