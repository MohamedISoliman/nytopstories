package io.github.mohamedisoliman

import android.app.Application
import timber.log.Timber

class NyTimesApp : Application() {


    override fun onCreate() {
        super.onCreate()

        init()
    }

    private fun init() {
        Timber.plant(Timber.DebugTree())
    }

}