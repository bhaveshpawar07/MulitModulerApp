package com.wednesday.core_presentation.base.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

data class CoroutineContextControllerImpl(
    val main: CoroutineDispatcher = Dispatchers.Main,
    override val default: CoroutineDispatcher = Dispatchers.Default,
    override val io: CoroutineDispatcher = Dispatchers.IO
) : CoroutineContextController {

    override suspend fun <R> switchToDefault(block: suspend CoroutineScope.() -> R): R =
        withContext(default) { block() }

    override suspend fun <R> switchToIO(block: suspend CoroutineScope.() -> R): R =
        withContext(io) { block() }
}
