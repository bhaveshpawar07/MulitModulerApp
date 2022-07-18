package com.wednesday.core_common.base

interface BaseUnsafeUseCase<IN, OUT> {

    operator fun invoke(param: IN): OUT
}
