package com.wednesday.core_common.base

sealed class Result<out T> {

    fun get(): T {
        return T
    }

    class Success<T>(val data: T) : Result<T>(){
//        fun get(): T {
//            return data;
//        }
    }



    class Error(val exception: Exception) : Result<Nothing>()
}
