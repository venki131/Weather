package com.venkatesh.weather.di

import com.venkatesh.weather.usecase.GetWeatherUseCase
import dagger.Component

@Component(
        modules = [
        WeatherDomainModule::class
        ]
)
interface WeatherDomainComponent {
    fun getGetWeatherUseCase() : GetWeatherUseCase
}