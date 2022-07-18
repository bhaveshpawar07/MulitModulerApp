package com.wednesday.feature_search.interactor

import com.wednesday.core_model.weather.City
import com.wednesday.core_presentation.model.base.UIList
import com.wednesday.feature_search.mappers.UICitySearchResultsMapper
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import timber.log.Timber
import com.wednesday.core_common.base.Result
import com.wednesday.core_presentation.base.coroutine.CoroutineContextController
import com.wednesday.feature_search.interactor.usecase.GetFavouriteCitiesFlowUseCase
import com.wednesday.feature_search.interactor.usecase.SearchCitiesUseCase

class SearchCityInteractorImpl(
    private val searchCitiesUseCase: SearchCitiesUseCase,
    favouriteCitiesFlowUseCase: GetFavouriteCitiesFlowUseCase,
    private val citySearchResultMapper: UICitySearchResultsMapper,
    private val coroutineContextController: CoroutineContextController
) : SearchCityInteractor {

    private val searchResultStateFlow = Channel<List<City>>()

    override val searchResultsFlow: Flow<Result<UIList>> = favouriteCitiesFlowUseCase(Unit)
        .combine(searchResultStateFlow.receiveAsFlow()) { favouriteCities, searchResults ->
            when {
                searchResults.isEmpty() -> {
                    Result.Success(UIList())
                }
                favouriteCities is Result.Success -> {
                    Result.Success(
                        citySearchResultMapper.map(
                            favouriteCities.data,
                            searchResults
                        )
                    )
                }
                favouriteCities is Result.Error -> {
                    Timber.e(favouriteCities.exception)
                    Result.Error(favouriteCities.exception)
                }
                else -> {
                    error("Something went wrong")
                }
            }
        }
        .onEach {
            Timber.tag(TAG).d("searchResultsFlow: emit = $it")
        }
        .flowOn(coroutineContextController.default)
        .catch { e ->
            emit(Result.Error(e as Exception))
        }

    override suspend fun search(term: String): Unit = coroutineContextController.switchToDefault {
        Timber.tag(TAG).d("search: term = $term")
        val list = when (val citiesResult = searchCitiesUseCase(term)) {
            is Result.Error -> {
                Timber.tag(TAG).e(citiesResult.exception, "search error")
                listOf()
            }
            is Result.Success -> citiesResult.data
        }
        searchResultStateFlow.send(list)
    }

    companion object {
        private const val TAG = "SearchCityInteractorImpl"
    }
}
