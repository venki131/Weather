package com.venkatesh.domain_weather.di

import com.venkatesh.domain_weather.usecase.GetWeatherUseCase
import dagger.Component

@Component(
        modules = [
        WeatherDomainModule::class
        ]
)
interface WeatherDomainComponent {
    fun getGetWeatherUseCase() : GetWeatherUseCase
}