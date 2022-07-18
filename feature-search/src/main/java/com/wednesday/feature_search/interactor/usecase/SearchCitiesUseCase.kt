package com.wednesday.feature_search.interactor.usecase

import com.wednesday.core_common.base.BaseSuspendUseCase
import com.wednesday.core_model.weather.City
import com.wednesday.core_repository.repository.weather.WeatherRepository
import timber.log.Timber

interface SearchCitiesUseCase : BaseSuspendUseCase<String, List<City>>

class SearchCitiesUseCaseImpl(
    private val weatherRepository: WeatherRepository
) : SearchCitiesUseCase {

    override suspend fun invokeInternal(param: String): List<City> {
        Timber.tag(TAG).d("invokeInternal: param = $param")
        return weatherRepository.searchCities(param)
    }

    companion object {
        private const val TAG = "SearchCitiesUseCaseImpl"
    }
}
