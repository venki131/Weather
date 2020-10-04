package com.venkatesh.data_weather.di

import com.venkatesh.core.di.CoreInjector
import com.venkatesh.domain_weather.di.WeatherDomainInjector

object WeatherDataInjector {
    lateinit var component: WeatherDataComponent

    fun initialise() {
        component = DaggerWeatherDataComponent.builder()
                .coreComponent(CoreInjector.coreComponent)
                .build()

        WeatherDomainInjector.initialize(
                component.getWeatherRepository(),
                component.getSchedulerProvider()
        )
    }
}