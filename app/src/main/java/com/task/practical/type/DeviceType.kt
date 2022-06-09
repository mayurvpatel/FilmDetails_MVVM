package com.task.practical.type

import androidx.annotation.StringDef

/**
 * Device type
 */
/**
 * Branding selection types for application
 */
@StringDef(DeviceType.Android, DeviceType.iOS, DeviceType.Web)
annotation class DeviceType {
    companion object {
        const val Android = "ANDROID"
        const val iOS = "IOS"
        const val Web = "WEB"
    }
}
