package com.venkatesh.weather.repository

import com.venkatesh.weather.model.Weather
import io.reactivex.Single

interface WeatherRepository {
    fun getWeather(): Single<Weather>
}