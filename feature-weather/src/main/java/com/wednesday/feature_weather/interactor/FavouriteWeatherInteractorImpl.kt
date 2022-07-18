package com.wednesday.feature_weather.interactor

import com.wednesday.core_common.base.Result
import com.wednesday.core_presentation.base.coroutine.CoroutineContextController
import com.wednesday.core_presentation.model.base.UIList
import com.wednesday.core_presentation.model.weather.UICity
import com.wednesday.feature_weather.interactor.usecase.FetchFavouriteCitiesWeatherUseCase
import com.wednesday.feature_weather.interactor.usecase.GetFavouriteCitiesFlowUseCase
import com.wednesday.feature_weather.interactor.usecase.GetFavouriteCitiesWeatherFlowUseCase
import com.wednesday.feature_weather.interactor.usecase.RemoveCityFavouriteUseCase
import com.wednesday.feature_weather.interactor.usecase.SetCityFavouriteUseCase
import com.wednesday.feature_weather.mappers.UICityMapper
import com.wednesday.feature_weather.mappers.UIWeatherListMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

class FavouriteWeatherInteractorImpl(
    private val setCityFavouriteUseCase: SetCityFavouriteUseCase,
    private val removeCityFavouriteUseCase: RemoveCityFavouriteUseCase,
    private val getFavouriteCitiesFlowUseCase: GetFavouriteCitiesFlowUseCase,
    private val getFavouriteCitiesWeatherFlowUseCase: GetFavouriteCitiesWeatherFlowUseCase,
    private val fetchFavouriteCitiesWeatherUseCase: FetchFavouriteCitiesWeatherUseCase,
    private val uiCityMapper: UICityMapper,
    private val weatherListMapper: UIWeatherListMapper,
    private val coroutineContextController: CoroutineContextController
) :  FavouriteWeatherInteractor {

    override suspend fun setCityFavourite(uiCity: UICity): Result<Unit> =
        coroutineContextController.switchToDefault {
            Timber.tag(TAG).d("setCityFavourite: city = $uiCity")
            val city = uiCityMapper.mapUICity(uiCity)
            setCityFavouriteUseCase(city)
        }

    override suspend fun removeCityFavourite(uiCity: UICity): Result<Unit> =
        coroutineContextController.switchToDefault {
            Timber.tag(TAG).d("removeCityFavourite: city = $uiCity")
            val city = uiCityMapper.mapUICity(uiCity)
            removeCityFavouriteUseCase(city)
        }

    override fun getFavouriteWeatherUIList(): Flow<Result<UIList>> {
        Timber.tag(TAG).d("getFavouriteCitiesFlow")
        return getFavouriteCitiesWeatherFlowUseCase(Unit)
            .distinctUntilChanged()
            .map {
//                when(it){
//                    is Result.Error -> TODO()
//                    is Result.Success -> Result.Success(weatherListMapper.map(it.data))
//                }
                Result.Success(weatherListMapper.map(it.get()))
            }
            .flowOn(coroutineContextController.default)
            .onEach {
//                Result.Success(it)
                Timber.tag(TAG).d("getFavouriteCitiesFlow: emit = $it")
            }
    }

    override fun getFavouriteCitiesFlow(): Flow<Result<List<UICity>>> {
        Timber.tag(TAG).d("getFavouriteCitiesFlow() called")
        return getFavouriteCitiesFlowUseCase(Unit)
            .mapToUIResult(success = {
                this.data.map(uiCityMapper::mapFavouriteCity)
            })
            .flowOn(coroutineContextController.default)
            .onEach { Timber.tag(TAG).d("getFavouriteCitiesFlow: emit = $it") }
    }

    override suspend fun fetchFavouriteCitiesWeather(): Result<Unit> =
        coroutineContextController.switchToDefault {
            Timber.tag(TAG).d("fetchFavouriteCities() called")
            fetchFavouriteCitiesWeatherUseCase(Unit).let(::mapResult)
        }

    companion object {
        private const val TAG = "FavouriteWeatherInteractorImpl"
    }
}
