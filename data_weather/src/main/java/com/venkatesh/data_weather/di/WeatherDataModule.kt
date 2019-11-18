package com.venkatesh.data_weather.di

import android.content.Context
import com.squareup.moshi.Moshi
import com.venkatesh.data_weather.remote.FakeRemoteDataSource
import com.venkatesh.data_weather.repository.WeatherRemoteDataSource
import com.venkatesh.data_weather.repository.WeatherRepositoryImpl
import com.venkatesh.domain_weather.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(
        includes = [
            WeatherDataModule.BindModule::class
        ]
)
class WeatherDataModule {

    @Provides
    @WeatherDataScope
    @Named("weather_json_path")
    fun provideJsonPath(): String = "weather.json"

    @Module
    interface BindModule {
        @Binds
        fun bindRepository(repository: WeatherRepositoryImpl): WeatherRepository
    }

    @Provides
    @WeatherDataScope
    fun provideWeatherRemoteDataSource(
            context: Context,
            moshi: Moshi,
            @Named("weather_json_path") jsonPath: String
    ): WeatherRemoteDataSource {
        return FakeRemoteDataSource(context, moshi, jsonPath)
    }
}