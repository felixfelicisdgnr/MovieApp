package com.doganur.movieapp.presentation.moviedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.doganur.movieapp.navigation.Screen
import com.doganur.movieapp.presentation.moviedetail.MovieDetailContract.UiAction
import com.doganur.movieapp.presentation.moviedetail.MovieDetailContract.UiEffect
import com.doganur.movieapp.presentation.moviedetail.MovieDetailContract.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _uiEffect by lazy { Channel<UiEffect>() }
    val uiEffect: Flow<UiEffect> by lazy { _uiEffect.receiveAsFlow() }

    init {
        val movieDetail: Screen.MovieDetail = savedStateHandle.toRoute()
        updateUiState { copy(
            movieId = movieDetail.movieId,
            name = movieDetail.name,
            image = movieDetail.image,
            price = movieDetail.price,
            category = movieDetail.category,
            rating = movieDetail.rating,
            year = movieDetail.year,
            director = movieDetail.director,
            description = movieDetail.description
        ) }
    }

    fun onAction(uiAction: UiAction) {
    }

    private fun updateUiState(block: UiState.() -> UiState) {
        _uiState.update(block)
    }

    private suspend fun emitUiEffect(uiEffect: UiEffect) {
        _uiEffect.send(uiEffect)
    }
}