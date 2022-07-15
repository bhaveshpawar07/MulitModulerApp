package com.wednesday.feature_search.interactor

import kotlinx.coroutines.flow.Flow

interface SearchCityInteractor {

    val searchResultsFlow: Flow<UIResult<UIList>>

    suspend fun search(term: String)
}
