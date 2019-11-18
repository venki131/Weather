package com.venkatesh.weather

import android.app.Application
import com.venkatesh.weather.di.AppInjector

open class WeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initialiseDagger()
    }

    private fun initialiseDagger() {
        AppInjector.initialise(this)
    }
}