package com.venkatesh.weather.di

import android.app.Application
import com.venkatesh.core.di.CoreInjector
import com.venkatesh.data_weather.di.WeatherDataInjector

object AppInjector {

    fun initialise(application: Application) {
        initialiseCore(application)
    }

    fun initialiseCore(application: Application) {
        CoreInjector.initialise(application)
    }

    private fun initialiseWeather() {
        WeatherDataInjector.initialise()
    }
}