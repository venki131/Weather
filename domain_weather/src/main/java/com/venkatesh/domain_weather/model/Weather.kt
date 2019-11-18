package com.venkatesh.domain_weather.model

data class Weather(
        val city: String,
        val dateTime: String,
        val weatherImage: String,
        val temperature: String,
        val feelsLike: String,
        val description: String,
        val precipitation: String,
        val uvIndex: String
)
