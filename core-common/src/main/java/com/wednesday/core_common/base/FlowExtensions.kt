package com.wednesday.core_common.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun <T, S> Flow<Result<T>>.mapToResult(
    failure: (Result.Error.() -> Result.Error)? = null,
    success: (T) -> S
): Flow<Result<S>> =
    map {
        when (it) {
            is Result.Success -> Result.Success(success(it.data))
            is Result.Error -> {
                if (failure != null) {
                    failure(it)
                } else {
                    Result.Error(it.exception)
                }
            }
        }
    }
