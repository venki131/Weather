package com.venkatesh.domain_weather.usecase

import com.venkatesh.core.domain.UseCase
import com.venkatesh.core.rx.SchedulerProvider
import com.venkatesh.core.rx.disposeWith
import io.reactivex.disposables.CompositeDisposable
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import com.venkatesh.domain_weather.model.Weather
import com.venkatesh.domain_weather.repository.WeatherRepository

class GetWeatherUseCase @Inject constructor(
        private val weatherRepository: WeatherRepository,
        private val schedulerProvider: SchedulerProvider
) : UseCase<GetWeatherUseCase.Status>() {
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

    open fun clear() {
        compositeDisposable.clear()
    }

    override fun executeUseCase(onStatus: (status: Status) -> Unit) {
        weatherRepository.getWeather().map<Status> { Status.Success(it) }
                .subscribeOn(schedulerProvider.newThread)
                .observeOn(schedulerProvider.mainThread)
                .subscribe(onStatus)
                .disposeWith(compositeDisposable)
    }

    private fun onError(throwable: Throwable): Status {
        return when (throwable) {
            is SocketTimeoutException -> Status.ConnectionError
            is UnknownHostException -> Status.ConnectionError
            is ConnectException -> Status.ConnectionError
            else -> {
                Status.UnKnownError
            }
        }
    }

    sealed class Status {
        data class Success(val weather: Weather) : Status()
        object ConnectionError : Status()
        object UnKnownError : Status()
    }
}

