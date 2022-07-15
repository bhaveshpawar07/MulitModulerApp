package com.wednesday.core_presentation.base.intent

interface IntentHandler<I : Intent> {

    fun onIntent(intent: I)
}
