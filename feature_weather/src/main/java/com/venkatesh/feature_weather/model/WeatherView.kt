package com.venkatesh.feature_weather.model

import android.os.Parcelable
import com.venkatesh.domain_weather.model.Weather
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherView(
        val city: String,
        val dateTime: String,
        val weatherImage: String,
        val temperature: String,
        val feelsLike: String,
        val description: String,
        val precipitation: String,
        val uvIndex: String) : Parcelable

fun Weather.mapToView(): WeatherView = WeatherView(
        this.city,
        this.dateTime,
        this.weatherImage,
        this.temperature,
        this.feelsLike,
        this.description,
        this.precipitation,
        this.uvIndex
)