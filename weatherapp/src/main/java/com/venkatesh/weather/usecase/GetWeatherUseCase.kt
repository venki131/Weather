package com.venkatesh.weather.usecase

import com.venkatesh.core.domain.UseCase
import com.venkatesh.core.rx.SchedulerProvider
import com.venkatesh.weather.model.Weather
import com.venkatesh.weather.repository.WeatherRepository
import io.reactivex.disposables.CompositeDisposable
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import com.venkatesh.core.rx.disposeWith

class GetWeatherUseCase @Inject constructor(
        private val weatherRepository: WeatherRepository,
        private val schedulerProvider: SchedulerProvider
) : UseCase<GetWeatherUseCase.Status>() {
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()

    open fun clear() {
        compositeDisposable.clear()
    }

    override fun executeUseCase(onStatus: (status: Status) -> Unit) {
        weatherRepository.getWeather().map<Status> { Status.Succes(it) }
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
        data class Succes(val weather: Weather) : Status()
        object ConnectionError : Status()
        object UnKnownError : Status()
    }
}

