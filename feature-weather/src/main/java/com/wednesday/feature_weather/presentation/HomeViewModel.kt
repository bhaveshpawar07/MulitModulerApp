package com.wednesday.feature_weather.presentation

import androidx.lifecycle.viewModelScope
import com.wednesday.core_presentation.base.intent.IntentHandler
import com.wednesday.core_presentation.base.viewmodel.BaseViewModel
import com.wednesday.core_presentation.model.base.UIList
import com.wednesday.core_presentation.model.base.UIText
import com.wednesday.core_presentation.model.base.UIToolbar
import com.wednesday.core_common.R
import com.wednesday.core_common.base.Result
import com.wednesday.core_navigation.home.HomeNavigator
import com.wednesday.core_presentation.base.effect.ShowSnackbarEffect
import com.wednesday.feature_weather.interactor.FavouriteWeatherInteractor
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeViewModel(
    private val favouriteWeatherInteractor: FavouriteWeatherInteractor,
) : BaseViewModel<HomeScreen, HomeScreenState, HomeNavigator>(),
    IntentHandler<HomeScreenIntent> {

    override fun getDefaultScreenState(): HomeScreenState {
        return HomeScreenState(
            toolbar = UIToolbar(
                title = UIText { block("Weather") },
                hasBackButton = false,
                menuIcon = R.drawable.ic_search,
            ),
            showLoading = false,
            items = UIList()
        )
    }

    override fun onCreate(fromRecreate: Boolean) {
        if (fromRecreate) return
        favouriteWeatherInteractor.getFavouriteCitiesFlow().onEach {
            favouriteWeatherInteractor.fetchFavouriteCitiesWeather()
        }.launchIn(viewModelScope)

        favouriteWeatherInteractor.getFavouriteWeatherUIList().onEach {
            when (it) {
                is Result.Success -> {
                    setState { copy(showLoading = false, items = it.data) }
                }
                is Result.Error -> {
                    setEffect(
                        ShowSnackbarEffect(
                            UIText {
                                block(com.wednesday.core_presentation.R.string.something_went_wrong)
                            }
                        )
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    override fun onIntent(intent: HomeScreenIntent) {
        when (intent) {
            is HomeScreenIntent.Search -> {
//                navigator.navigateTo(SearchScreen)
            }
            HomeScreenIntent.Loading -> {
                setState { copy(showLoading = !showLoading) }
            }
            HomeScreenIntent.Loading2 -> setState { copy(toolbar = toolbar.copy(hasBackButton = !toolbar.hasBackButton)) }
            HomeScreenIntent.Loading3 -> setState {
                copy(
                    toolbar = toolbar.copy(
                        title = UIText {
                            block("${System.currentTimeMillis()}")
                        }
                    )
                )
            }
        }
    }
}
