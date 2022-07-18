package com.wednesday.feature_weather.interactor.usecase

import com.wednesday.core_common.base.BaseSuspendUseCase
import com.wednesday.core_model.weather.City
import com.wednesday.core_repository.repository.weather.WeatherRepository
import timber.log.Timber

interface RemoveCityFavouriteUseCase : BaseSuspendUseCase<City, Unit>

class RemoveCityFavouriteUseCaseImpl(
    private val weatherRepository: WeatherRepository
) : RemoveCityFavouriteUseCase {

    override suspend fun invokeInternal(param: City) {
        Timber.tag(TAG).d("invokeInternal: param = $param")
        return weatherRepository.removeCityAsFavourite(param)
    }

    companion object {
        private const val TAG = "RemoveCityFavouriteUseCaseImpl"
    }
}
