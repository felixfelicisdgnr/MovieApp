package com.doganur.movieapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doganur.movieapp.common.EMPTY
import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.domain.usecase.AddBasketUseCase
import com.doganur.movieapp.domain.usecase.GetMoviesUseCase
import com.doganur.movieapp.presentation.home.HomeContract.UiAction
import com.doganur.movieapp.presentation.home.HomeContract.UiEffect
import com.doganur.movieapp.presentation.home.HomeContract.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val addBasketUseCase: AddBasketUseCase,
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _uiEffect by lazy { Channel<UiEffect>() }
    val uiEffect: Flow<UiEffect> by lazy { _uiEffect.receiveAsFlow() }

    init {
        getMovies()
    }

    fun onAction(uiAction: UiAction) {
        when (uiAction) {
            is UiAction.OnAddToBasketClick -> addToBasket(uiAction.movieModel)

            is UiAction.OnMovieItemClick -> viewModelScope.launch {
                emitUiEffect(UiEffect.NavigateToMovieDetail(uiAction.movieModel))
            }

            is UiAction.OnCategoryClick -> {
                if (uiAction.category == uiState.value.selectedCategory) {
                    updateUiState {
                        copy(selectedCategory = String.EMPTY)
                    }
                } else {
                    updateUiState {
                        copy(selectedCategory = uiAction.category)
                    }
                }

                getMovies()
            }

            is UiAction.OnSortTypeChange -> {
                updateUiState { copy(selectedSortType = uiAction.sortType) }
                getMovies()
            }

            is UiAction.OnSearchValueChange -> {
                updateUiState {
                    copy(searchText = uiAction.searchText)
                }
                getMovies()
            }
        }
    }

    private fun addToBasket(movieModel: MovieModel) = viewModelScope.launch {
        val result = addBasketUseCase(
            name = movieModel.name,
            price = movieModel.price,
            image = movieModel.image,
            category = movieModel.category,
            rating = movieModel.rating,
            year = movieModel.year,
            director = movieModel.director,
            description = movieModel.description,
        )
        when (result) {
            is Resource.Success -> emitUiEffect(UiEffect.ShowToast(message = result.data))
            is Resource.Fail -> emitUiEffect(UiEffect.ShowToast(message = result.message))
        }
    }

    private fun getMovies() = viewModelScope.launch {
        updateUiState { copy(isLoading = true) }

        val searchText = uiState.value.searchText
        val searchSort = uiState.value.selectedSortType
        val searchCategory = uiState.value.selectedCategory

        when (val result = getMoviesUseCase(searchText, searchSort, searchCategory)) {
            is Resource.Success -> {
                updateUiState {
                    copy(
                        movies = result.data, isLoading = false
                    )
                }

                if (searchCategory == String.EMPTY) {
                    updateUiState {
                        copy(categories = result.data.map { it.category }.distinct())
                    }
                }
            }

            is Resource.Fail -> {
                updateUiState { copy(isLoading = false) }
                emitUiEffect(UiEffect.ShowToast(message = result.message))
            }
        }
    }

    private fun updateUiState(block: UiState.() -> UiState) {
        _uiState.update(block)
    }

    private suspend fun emitUiEffect(uiEffect: UiEffect) {
        _uiEffect.send(uiEffect)
    }
}