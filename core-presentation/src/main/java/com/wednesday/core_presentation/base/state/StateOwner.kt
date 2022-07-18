package com.wednesday.core_presentation.base.state

import androidx.lifecycle.SavedStateHandle

interface StateOwner {

    val savedStateHandle: SavedStateHandle
}
