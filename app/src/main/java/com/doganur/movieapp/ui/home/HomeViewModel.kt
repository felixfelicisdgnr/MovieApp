package com.doganur.movieapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.domain.usecase.AddBasketUseCase
import com.doganur.movieapp.domain.usecase.GetAllMoviesUseCase
import com.doganur.movieapp.ui.home.HomeContract.UiAction
import com.doganur.movieapp.ui.home.HomeContract.UiEffect
import com.doganur.movieapp.ui.home.HomeContract.UiState
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
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _uiEffect by lazy { Channel<UiEffect>() }
    val uiEffect: Flow<UiEffect> by lazy { _uiEffect.receiveAsFlow() }

    init {
        getAllMovies()
    }

    fun onAction(uiAction: UiAction) {
        when (uiAction) {
            is UiAction.OnAddToBasketClick -> addToBasket(uiAction.movieModel)
        }
    }

    private fun getAllMovies() = viewModelScope.launch {
        when (val result = getAllMoviesUseCase()) {
            is Resource.Success -> updateUiState { copy(list = result.data) }
            is Resource.Fail -> emitUiEffect(UiEffect.ShowToast(message = result.message))
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

    private fun updateUiState(block: UiState.() -> UiState) {
        _uiState.update(block)
    }

    private suspend fun emitUiEffect(uiEffect: UiEffect) {
        _uiEffect.send(uiEffect)
    }
}