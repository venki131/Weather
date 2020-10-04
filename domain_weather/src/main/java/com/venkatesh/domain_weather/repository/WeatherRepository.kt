package com.venkatesh.domain_weather.repository

import com.venkatesh.domain_weather.model.Weather
import io.reactivex.Single

interface WeatherRepository {
    fun getWeather(): Single<Weather>
}