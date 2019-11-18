package com.venkatesh.data_weather.repository


import com.venkatesh.domain_weather.model.Weather
import io.reactivex.Single

interface WeatherRemoteDataSource {

    fun getWeather() : Single<Weather>
}