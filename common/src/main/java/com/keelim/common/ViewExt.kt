package com.keelim.common

import android.content.Context
import android.view.View
import androidx.annotation.Px

@Px
fun View.dip(dipValue: Float) = context.dip(dipValue)

fun View.toVisible() {
    visibility = View.VISIBLE
}

fun View.toGone() {
    visibility = View.GONE
}

@Px
fun Context.dip(dipValue: Float) = (dipValue * resources.displayMetrics.density).toInt()
