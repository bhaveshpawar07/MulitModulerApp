package com.wednesday.feature_search.interactor.usecase

import com.wednesday.core_common.base.BaseFlowUseCase
import com.wednesday.core_model.weather.City
import com.wednesday.core_repository.repository.weather.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

interface GetFavouriteCitiesFlowUseCase : BaseFlowUseCase<Unit, List<City>>

class GetFavouriteCitiesFlowUseCaseImpl(
    private val weatherRepository: WeatherRepository
) : GetFavouriteCitiesFlowUseCase {

    override fun invokeInternal(param: Unit): Flow<List<City>> {
        Timber.tag(TAG).d("invokeInternal")
        return weatherRepository.getFavouriteCitiesFlow()
            .onEach { Timber.tag(TAG).d("invokeInternal: emit = $it") }
    }

    companion object {
        private const val TAG = "GetFavouriteCitiesFlowUseCaseImpl"
    }
}
