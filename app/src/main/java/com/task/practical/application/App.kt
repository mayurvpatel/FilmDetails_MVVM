package com.task.practical.application

import android.app.Application
import com.task.practical.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Application class
 */
@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    /**
     * Initialise timber for debug mode
     */
    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            // Show logs only when on debug
            Timber.plant(Timber.DebugTree())
        }
    }

}
