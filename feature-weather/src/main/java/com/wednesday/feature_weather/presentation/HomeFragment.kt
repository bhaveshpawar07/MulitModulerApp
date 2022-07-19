package com.wednesday.feature_weather.presentation

import com.wednesday.template.presentation.base.snackbar.SnackbarComponent
import com.wednesday.template.presentation.weather.home.list.UIWeatherRenderer
import com.wednesday.core_common.R
import com.wednesday.core_common.databinding.FragmentStartBinding
import com.wednesday.core_navigation.home.HomeNavigator
import com.wednesday.core_presentation.base.effect.Effect
import com.wednesday.core_presentation.base.effect.ShowSnackbarEffect
import com.wednesday.core_presentation.base.fragment.BindingProvider
import com.wednesday.core_presentation.base.fragment.MainFragment
import com.wednesday.core_presentation.base.list.ListComponent
import com.wednesday.core_presentation.base.toolbar.ToolbarComponent
import com.wednesday.feature_weather.presentation.list.UISearchCitiesPlaceholderRenderer
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : MainFragment<
        FragmentStartBinding,
        HomeScreen,
        HomeScreenState,
        HomeNavigator,
        HomeViewModel>() {

    override val toolbarComponent: ToolbarComponent = ToolbarComponent(this) {
        viewModel.onIntent(HomeScreenIntent.Search)
    }

    override val viewModel: HomeViewModel by viewModel()

    override val navigator: HomeNavigator by navigator()

    override val bindingProvider: BindingProvider<FragmentStartBinding> =
        FragmentStartBinding::inflate

    private val listComponent by component {
        ListComponent(viewModel, R.id.recyclerView) {
            addRenderer(UISearchCitiesPlaceholderRenderer())
            addRenderer(UIWeatherRenderer())
        }
    }

    private val snackbarComponent by component {
        SnackbarComponent(this)
    }

    override fun onState(screenState: HomeScreenState) {
        super.onState(screenState)
        listComponent.setData(screenState.items)
    }

    override fun onEffect(effect: Effect) {
        when (effect) {
            is ShowSnackbarEffect -> snackbarComponent.setData(effect)
            else -> unhandledEffect(effect)
        }
    }
}
