package com.venkatesh.data_weather.repository

import com.venkatesh.core.rx.SchedulerProvider
import com.venkatesh.domain_weather.model.Weather
import com.venkatesh.domain_weather.repository.WeatherRepository
import io.reactivex.Single
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
        private val remoteDataSource: WeatherRemoteDataSource,
        private val schedulerProvider: SchedulerProvider
) : WeatherRepository {
    override fun getWeather(): Single<Weather> {
        return remoteDataSource.getWeather()
                .subscribeOn(schedulerProvider.io)
    }
}