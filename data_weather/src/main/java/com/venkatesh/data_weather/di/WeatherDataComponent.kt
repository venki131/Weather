package com.venkatesh.data_weather.di

import com.venkatesh.core.di.CoreComponent
import com.venkatesh.domain_weather.repository.WeatherRepository
import dagger.Component
import javax.inject.Provider

@WeatherDataScope
@Component(
        modules = [WeatherDataModule::class], dependencies = [CoreComponent::class]
)
interface WeatherDataComponent : CoreComponent {
    fun getWeatherRepository(): Provider<WeatherRepository>
}