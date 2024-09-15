package com.junemon.wastetreatment.util

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class UtilityHelperImpl @Inject constructor(@ApplicationContext private val context: Context) :
    UtilityHelper {

    override fun getDrawable(resources: Int): Drawable? {
        return AppCompatResources.getDrawable(context, resources)
    }

    override fun getString(resources: Int): String {
        return context.getString(resources)
    }
}