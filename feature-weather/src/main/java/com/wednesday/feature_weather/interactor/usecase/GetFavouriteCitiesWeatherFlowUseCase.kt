package com.wednesday.feature_weather.interactor.usecase

import com.wednesday.core_common.base.BaseFlowUseCase
import com.wednesday.core_model.weather.Weather
import com.wednesday.core_repository.repository.weather.WeatherRepository
import timber.log.Timber
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach


interface GetFavouriteCitiesWeatherFlowUseCase : BaseFlowUseCase<Unit, List<Weather>>

class GetFavouriteCitiesWeatherFlowUseCaseImpl(
    private val weatherRepository: WeatherRepository
) : GetFavouriteCitiesWeatherFlowUseCase {

    override fun invokeInternal(param: Unit): Flow<List<Weather>> {
        Timber.tag(TAG).d("invokeInternal() called with: param = $param")
        return weatherRepository.getFavouriteCitiesWeatherFlow()
            .onEach { Timber.tag(TAG).d("invokeInternal: emit = $it") }
    }

    companion object {
        private const val TAG = "GetFavouriteCitiesWeatherFlowUseCaseImpl"
    }
}
