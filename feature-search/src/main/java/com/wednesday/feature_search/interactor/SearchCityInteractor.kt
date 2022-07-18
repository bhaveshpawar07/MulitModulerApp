package com.wednesday.feature_search.interactor

import com.wednesday.core_common.base.Result
import com.wednesday.core_presentation.model.base.UIList
import kotlinx.coroutines.flow.Flow

interface SearchCityInteractor {

    val searchResultsFlow: Flow<Result<UIList>>

    suspend fun search(term: String)
}
