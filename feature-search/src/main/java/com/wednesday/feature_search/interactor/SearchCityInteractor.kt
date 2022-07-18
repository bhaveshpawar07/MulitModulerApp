package com.wednesday.feature_search.interactor

import com.wednesday.core_presentation.model.base.UIList
import com.wednesday.core_presentation.model.base.UIResult
import kotlinx.coroutines.flow.Flow

interface SearchCityInteractor {

    val searchResultsFlow: Flow<UIResult<UIList>>

    suspend fun search(term: String)
}
