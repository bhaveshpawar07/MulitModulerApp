package com.wednesday.feature_search.di

import com.wednesday.core_presentation.base.coroutine.CoroutineContextController
import com.wednesday.core_presentation.base.coroutine.CoroutineContextControllerImpl
import com.wednesday.feature_search.interactor.SearchCityInteractor
import com.wednesday.feature_search.interactor.SearchCityInteractorImpl
import com.wednesday.feature_search.interactor.usecase.GetFavouriteCitiesFlowUseCase
import com.wednesday.feature_search.interactor.usecase.GetFavouriteCitiesFlowUseCaseImpl
import com.wednesday.feature_search.interactor.usecase.SearchCitiesUseCase
import com.wednesday.feature_search.interactor.usecase.SearchCitiesUseCaseImpl
import com.wednesday.feature_search.mappers.UICityMapper
import com.wednesday.feature_search.mappers.UICityMapperImpl
import com.wednesday.feature_search.mappers.UICitySearchResultsMapper
import com.wednesday.feature_search.mappers.UICitySearchResultsMapperImpl
import com.wednesday.feature_search.presentation.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchModule = module {

    //Use Case
    single<GetFavouriteCitiesFlowUseCase> { GetFavouriteCitiesFlowUseCaseImpl(get()) }
    single<SearchCitiesUseCase> { SearchCitiesUseCaseImpl(get()) }

    // Coroutine
    single<CoroutineContextController> { CoroutineContextControllerImpl() }

    // Mapper
    single<UICityMapper> { UICityMapperImpl() }
    single<UICitySearchResultsMapper> { UICitySearchResultsMapperImpl(get()) }

    //Interactor
    factory<SearchCityInteractor> { SearchCityInteractorImpl(get(),get(),get(),get()) }

    //viewModel
    viewModel { SearchViewModel(get(), get()) }
}