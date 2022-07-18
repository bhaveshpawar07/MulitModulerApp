package com.wednesday.feature_weather.interactor.usecase

import com.wednesday.core_common.base.BaseSuspendUseCase
import com.wednesday.core_repository.repository.weather.WeatherRepository
import timber.log.Timber

interface FetchFavouriteCitiesWeatherUseCase : BaseSuspendUseCase<Unit, Unit>

class FetchFavouriteCitiesWeatherUseCaseImpl(
    private val weatherRepository: WeatherRepository
) : FetchFavouriteCitiesWeatherUseCase {

    override suspend fun invokeInternal(param: Unit) {
        Timber.tag(TAG).d("invokeInternal() called with: param = $param")
        weatherRepository.fetchWeatherForFavouriteCities()
    }

    companion object {
        private const val TAG = "FetchFavouriteCitiesWeatherUseCaseImpl"
    }
}