package com.wednesday.core_presentation.model.base

sealed class UIResult<out T> {

    data class Success<T>(val data: T) : UIResult<T>()

    data class Error(val exception: Exception) : UIResult<Nothing>()
}
