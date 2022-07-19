package com.wednesday.feature_search.presentation

import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import com.wednesday.core_common.databinding.FragmentSearchBinding
import com.wednesday.core_navigation.search.SearchNavigator
import com.wednesday.core_presentation.base.fragment.BindingProvider
import com.wednesday.core_presentation.base.fragment.MainFragment
import com.wednesday.core_presentation.base.list.ListComponent
import com.wednesday.core_presentation.base.toolbar.ToolbarComponent
import com.wednesday.core_common.R
import com.wednesday.core_presentation.base.common.HideKeyboardComponent
import com.wednesday.core_presentation.base.effect.Effect
import com.wednesday.core_presentation.base.effect.HideKeyboardEffect
import com.wednesday.core_presentation.base.effect.ShowSnackbarEffect
import com.wednesday.feature_search.presentation.list.UICityListRenderer
import com.wednesday.template.presentation.base.snackbar.SnackbarComponent
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class SearchFragment : MainFragment<FragmentSearchBinding,
        SearchScreen,
        SearchScreenState,
        SearchNavigator,
        SearchViewModel>() {

    override val toolbarComponent: ToolbarComponent = ToolbarComponent(this, onBackClicked = {
        viewModel.onIntent(SearchScreenIntent.Back)
    })

    override val viewModel: SearchViewModel by viewModel()

    override val navigator: SearchNavigator by navigator()

    override val bindingProvider: BindingProvider<FragmentSearchBinding> =
        FragmentSearchBinding::inflate

    private val listComponent by component {
        ListComponent(listViewModel = viewModel, recyclerViewId = R.id.searchRecyclerView) {
            addRenderer(UICityListRenderer())
        }
    }
    private val snackbarComponent by component {
        SnackbarComponent(this)
    }

    private val hideKeyboardComponent by component {
        HideKeyboardComponent(requireActivity())
    }

    override fun onViewCreated(binding: FragmentSearchBinding) {
        super.onViewCreated(binding)

        addTextListener(binding)
    }

    override fun onEffect(effect: Effect) {
        when (effect) {
            is HideKeyboardEffect -> hideKeyboardComponent.setData(effect)
            is ShowSnackbarEffect -> snackbarComponent.setData(effect)
            else -> unhandledEffect(effect)
        }
    }

    override fun onState(screenState: SearchScreenState) {
        super.onState(screenState)
        listComponent.setData(screenState.searchList)
    }

    private fun addTextListener(binding: FragmentSearchBinding) = with(binding) {

        searchEditText.addTextChangedListener {
            it?.let { viewModel.onIntent(SearchScreenIntent.SearchCities(it.toString())) }
        }

        searchEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                onEffect(HideKeyboardEffect)
                Timber.d("User Completed Search")
            }
            false
        }
    }
}
