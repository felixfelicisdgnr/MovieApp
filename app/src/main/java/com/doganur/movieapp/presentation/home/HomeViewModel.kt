package com.doganur.movieapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doganur.movieapp.common.EMPTY
import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.domain.model.SortType
import com.doganur.movieapp.domain.usecase.AddBasketUseCase
import com.doganur.movieapp.domain.usecase.GetAllMoviesUseCase
import com.doganur.movieapp.domain.usecase.GetMoviesByCategoryUseCase
import com.doganur.movieapp.domain.usecase.GetSortedMoviesUseCase
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
    private val getAllMoviesUseCase: GetAllMoviesUseCase,
    private val addBasketUseCase: AddBasketUseCase,
    private val getMoviesByCategoryUseCase: GetMoviesByCategoryUseCase,
    private val getSortedMoviesUseCase: GetSortedMoviesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _uiEffect by lazy { Channel<UiEffect>() }
    val uiEffect: Flow<UiEffect> by lazy { _uiEffect.receiveAsFlow() }

    private var allMovies: List<MovieModel> = emptyList()

    init {
        getAllMovies()
    }

    fun onAction(uiAction: UiAction) {
        when (uiAction) {
            is UiAction.OnAddToBasketClick -> addToBasket(uiAction.movieModel)

            is UiAction.OnMovieItemClick -> viewModelScope.launch {
                emitUiEffect(UiEffect.NavigateToMovieDetail(uiAction.movieModel))
            }

            is UiAction.OnCategoryClick -> {
                val newCategory = if (uiState.value.selectedCategory == uiAction.category) {
                    String.EMPTY
                } else {
                    uiAction.category
                }
                getMoviesByCategory(newCategory)
            }

            is UiAction.OnSortTypeChange -> {
                updateUiState { copy(selectedSortType = uiAction.sortType) }
                getMovies()
            }

            is UiAction.OnSearchValueChange -> {
                updateUiState { copy(searchText = uiAction.searchText) }
            }
        }
    }

    private fun getAllMovies() = viewModelScope.launch {
        updateUiState { copy(isLoading = true) }

        when (val result = getAllMoviesUseCase()) {

            is Resource.Success -> {
                allMovies = result.data
                updateUiState {
                    copy(
                        list = allMovies,
                        isLoading = false
                    )
                }
            }

            is Resource.Fail -> {
                emitUiEffect(UiEffect.ShowToast(message = result.message))
                updateUiState { copy(isLoading = false) }
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

    private fun getMoviesByCategory(category: String) = viewModelScope.launch {
        updateUiState { copy(isLoading = true) }

        when (val result = getMoviesByCategoryUseCase(category)) {
            is Resource.Success -> updateUiState {
                copy(
                    list = if (category.isEmpty()) allMovies else result.data,
                    selectedCategory = category,
                    isLoading = false
                )
            }

            is Resource.Fail -> {
                emitUiEffect(UiEffect.ShowToast(message = result.message))
                updateUiState { copy(isLoading = false) }
            }
        }
    }

    private fun getMovies() = viewModelScope.launch {
        updateUiState { copy(isLoading = true) }

        // Önce kategoriye göre filtrele
        val categoryResult = if (uiState.value.selectedCategory.isEmpty()) {
            getSortedMoviesUseCase(uiState.value.selectedSortType)
        } else {
            when (val result = getMoviesByCategoryUseCase(uiState.value.selectedCategory)) {
                is Resource.Success -> {
                    // Kategori filtrelenmiş listeyi sırala
                    val sortedList = when (uiState.value.selectedSortType) {
                        SortType.PRICE_ASC -> result.data.sortedBy { it.price }
                        SortType.PRICE_DESC -> result.data.sortedByDescending { it.price }
                        SortType.NEWEST -> result.data.sortedByDescending { it.year }
                        SortType.NAME_ASC -> result.data.sortedBy { it.name }
                        SortType.NAME_DESC -> result.data.sortedByDescending { it.name }
                        SortType.RATE_ASC -> result.data.sortedByDescending { it.rating }
                    }
                    Resource.Success(sortedList)
                }
                is Resource.Fail -> result
            }
        }

        when (categoryResult) {
            is Resource.Success -> {
                updateUiState {
                    copy(
                        list = categoryResult.data,
                        isLoading = false
                    )
                }
            }
            is Resource.Fail -> {
                emitUiEffect(UiEffect.ShowToast(message = categoryResult.message))
                updateUiState { copy(isLoading = false) }
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