package com.venkatesh.weather.di

import com.venkatesh.core.rx.SchedulerProvider
import com.venkatesh.weather.repository.WeatherRepository
import javax.inject.Provider

object WeatherDomainInjector {
    lateinit var component: WeatherDomainComponent

    fun initialize(repository: Provider<WeatherRepository>, schedulerProvider: SchedulerProvider) {
        component = DaggerWeatherDomainComponent.builder()
                .weatherDomainModule(
                        WeatherDomainModule(
                                repository = repository,
                                schedulerProvider =  schedulerProvider
                        )
                )
                .build()
    }
}