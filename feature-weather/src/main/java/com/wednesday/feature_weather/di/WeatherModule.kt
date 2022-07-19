package com.wednesday.feature_weather.di

import com.wednesday.core_presentation.base.coroutine.CoroutineContextController
import com.wednesday.core_presentation.base.coroutine.CoroutineContextControllerImpl
import com.wednesday.feature_weather.interactor.FavouriteWeatherInteractor
import com.wednesday.feature_weather.interactor.FavouriteWeatherInteractorImpl
import com.wednesday.feature_weather.interactor.usecase.FetchFavouriteCitiesWeatherUseCase
import com.wednesday.feature_weather.interactor.usecase.FetchFavouriteCitiesWeatherUseCaseImpl
import com.wednesday.feature_weather.interactor.usecase.GetFavouriteCitiesFlowUseCase
import com.wednesday.feature_weather.interactor.usecase.GetFavouriteCitiesFlowUseCaseImpl
import com.wednesday.feature_weather.interactor.usecase.GetFavouriteCitiesWeatherFlowUseCase
import com.wednesday.feature_weather.interactor.usecase.GetFavouriteCitiesWeatherFlowUseCaseImpl
import com.wednesday.feature_weather.interactor.usecase.RemoveCityFavouriteUseCase
import com.wednesday.feature_weather.interactor.usecase.RemoveCityFavouriteUseCaseImpl
import com.wednesday.feature_weather.interactor.usecase.SetCityFavouriteUseCase
import com.wednesday.feature_weather.interactor.usecase.SetCityFavouriteUseCaseImpl
import com.wednesday.feature_weather.mappers.UICityMapper
import com.wednesday.feature_weather.mappers.UICityMapperImpl
import com.wednesday.feature_weather.mappers.UIWeatherListMapper
import com.wednesday.feature_weather.mappers.UIWeatherListMapperImpl
import com.wednesday.feature_weather.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherModule = module {

    //Use Case
    single<GetFavouriteCitiesFlowUseCase> { GetFavouriteCitiesFlowUseCaseImpl(get()) }

    single<SetCityFavouriteUseCase> { SetCityFavouriteUseCaseImpl(get()) }

    single<RemoveCityFavouriteUseCase> { RemoveCityFavouriteUseCaseImpl(get()) }

    single<GetFavouriteCitiesWeatherFlowUseCase> { GetFavouriteCitiesWeatherFlowUseCaseImpl(get()) }

    single<FetchFavouriteCitiesWeatherUseCase> { FetchFavouriteCitiesWeatherUseCaseImpl(get()) }

    // Coroutine
    single<CoroutineContextController> { CoroutineContextControllerImpl() }

    // Mapper
    single<UICityMapper> { UICityMapperImpl() }
    single<UIWeatherListMapper> { UIWeatherListMapperImpl() }

    //Interactor
    factory<FavouriteWeatherInteractor> { FavouriteWeatherInteractorImpl(get(),get(),get(),get(),get(),get(),get(),get()) }

    //viewModel
    viewModel { HomeViewModel(get()) }
}