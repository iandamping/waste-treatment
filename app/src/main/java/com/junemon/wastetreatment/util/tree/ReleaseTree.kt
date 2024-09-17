package com.junemon.wastetreatment.util.tree

import android.util.Log
import timber.log.Timber

class ReleaseTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.ERROR || priority == Log.WARN) {
            // SEND ERROR REPORTS TO YOUR Crashlytics.
        }
    }
}
