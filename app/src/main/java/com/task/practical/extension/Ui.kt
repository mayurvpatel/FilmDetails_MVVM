package com.task.practical.extension

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Activity.showToast(@StringRes resource: Int, duration: Int = Toast.LENGTH_SHORT) =
    showToast(getString(resource), duration)

fun Activity.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, duration).show()

fun Context.showToast(@StringRes resource: Int, duration: Int = Toast.LENGTH_SHORT) =
    showToast(getString(resource), duration)

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, duration).show()

fun Fragment.showToast(@StringRes resource: Int, duration: Int = Toast.LENGTH_SHORT) =
    showToast(getString(resource), duration)

fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) =
    activity?.showToast(message, duration)

fun Activity.showToastWithGravity(
    message: String,
    duration: Int = Toast.LENGTH_SHORT,
    gravity: Int = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
) {
    Toast.makeText(this, message, duration)?.apply {
        setGravity(gravity, 0, 0)
        show()
    }
}
