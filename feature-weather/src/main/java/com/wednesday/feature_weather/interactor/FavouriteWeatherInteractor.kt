package com.wednesday.feature_weather.interactor

import com.wednesday.core_presentation.model.base.UIList
import com.wednesday.core_presentation.model.weather.UICity
import com.wednesday.core_common.base.Result
import kotlinx.coroutines.flow.Flow

interface FavouriteWeatherInteractor {

    suspend fun setCityFavourite(uiCity: UICity): com.wednesday.core_common.base.Result<Unit>

    suspend fun removeCityFavourite(uiCity: UICity): Result<Unit>

    fun getFavouriteWeatherUIList(): Flow<Result<UIList>>

    fun getFavouriteCitiesFlow(): Flow<Result<List<UICity>>>

    suspend fun fetchFavouriteCitiesWeather(): Result<Unit>
}
