package com.venkatesh.data_weather.remote

import android.content.Context
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.venkatesh.data_weather.repository.WeatherRemoteDataSource
import com.venkatesh.domain_weather.model.Weather
import io.reactivex.Single
import java.io.InputStream
import javax.inject.Inject
import javax.inject.Named

class FakeRemoteDataSource @Inject constructor(
        private val context: Context,
        private val moshi: Moshi,
        @Named("weather_json_path") private val jsonPath: String
) : WeatherRemoteDataSource {
    override fun getWeather(): Single<Weather> {
        return Single.create<Weather> {
            val jsonAdapter: JsonAdapter<Weather> = moshi.adapter<Weather>(Weather::class.java)
            val inputStream: InputStream = context.assets.open(jsonPath)
            val inputString = inputStream.bufferedReader().use { reader -> reader.readText() }
            val weather = jsonAdapter.fromJson(inputString)

            if (weather != null) {
                it.onSuccess(weather)
            } else {
                it.onError(RuntimeException("Couldn't fetch weather"))
            }
        }
    }
}