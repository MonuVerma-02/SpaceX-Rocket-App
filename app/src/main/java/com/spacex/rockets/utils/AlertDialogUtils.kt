package com.spacex.rockets.utils

import android.content.Context
import androidx.appcompat.app.AppCompatDialog
import com.spacex.rockets.R

var alertDialog: AppCompatDialog? = null

fun Context.showProgressBar() {
    if (alertDialog == null) {
        alertDialog = AppCompatDialog(this, R.style.ProgressBarStyle)
        alertDialog?.setContentView(R.layout.progress_bar)
        alertDialog?.setCancelable(false)
    }
    try {
        if (alertDialog != null) {
            if (!alertDialog!!.isShowing)
                alertDialog?.show()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun hideProgressBar() {
    try {
        if (alertDialog != null) {
            if (alertDialog!!.isShowing) {
                alertDialog?.dismiss()
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        alertDialog = null
    }
}
