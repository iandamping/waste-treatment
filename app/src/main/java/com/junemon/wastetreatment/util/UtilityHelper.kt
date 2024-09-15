package com.junemon.wastetreatment.util

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface UtilityHelper {

    fun getDrawable(@DrawableRes resources: Int): Drawable?

    fun getString(@StringRes resources: Int): String
}
