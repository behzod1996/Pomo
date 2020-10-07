package com.hfad.pomo.extension

import android.util.DisplayMetrics
import android.view.View

fun View.convertDpToPixel(dp: Float): Float {
    return dp * (this.context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}