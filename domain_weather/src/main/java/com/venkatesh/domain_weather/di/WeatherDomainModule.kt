package com.venkatesh.domain_weather.di

import com.venkatesh.core.rx.SchedulerProvider
import com.venkatesh.domain_weather.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class WeatherDomainModule(
        private val repository: Provider<WeatherRepository>,
        private val schedulerProvider: SchedulerProvider
) {
    @Provides
    fun provideWeatherRepository(): WeatherRepository = repository.get()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = schedulerProvider
}