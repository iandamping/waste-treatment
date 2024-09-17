package com.junemon.wastetreatment.base

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.view.ContextThemeWrapper
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.junemon.wastetreatment.R

open class BaseActivity : AppCompatActivity() {

    protected fun disableNightMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    protected fun isPermissionGrantedForTiramisu(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    protected fun isShowRequestPermissionRationaleForTiramisu(): Boolean {
        return shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)
    }

    protected fun showMaterialDialog(title: String, message: String): MaterialAlertDialogBuilder {
        val context: Context = ContextThemeWrapper(this, R.style.MyCustomDialogTheme)
        return MaterialAlertDialogBuilder(context)
            .setTitle(title)
            .setMessage(message)
    }

    protected fun snacker(view: View, message: String, duration: Int = Snackbar.LENGTH_SHORT) {
        Snackbar.make(this, view, message, duration).show()
    }
}