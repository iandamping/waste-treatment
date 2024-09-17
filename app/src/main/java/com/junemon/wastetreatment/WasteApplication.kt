package com.junemon.wastetreatment

import android.app.Application
import com.junemon.wastetreatment.util.tree.ReleaseTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class WasteApplication : Application() {

    companion object{
        private const val DEBUG_NON_API_VERSION = "debug-non-api"
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            if (BuildConfig.DEBUG || BuildConfig.BUILD_TYPE == DEBUG_NON_API_VERSION) {
                Timber.plant(object : Timber.DebugTree() {
                    override fun createStackElementTag(element: StackTraceElement): String {
                        return String.format(
                            "Class:%s: Line: %s, Method: %s",
                            super.createStackElementTag(element),
                            element.lineNumber,
                            element.methodName
                        )
                    }
                })
            } else {
                Timber.plant(ReleaseTree())
            }
        }
    }
}