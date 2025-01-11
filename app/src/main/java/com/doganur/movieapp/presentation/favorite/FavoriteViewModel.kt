package com.doganur.movieapp.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doganur.movieapp.data.model.FavoriteMovie
import com.doganur.movieapp.domain.usecase.DeleteFavoriteMovieUseCase
import com.doganur.movieapp.domain.usecase.GetFavoriteMoviesUseCase
import com.doganur.movieapp.presentation.favorite.FavoriteContract.UiAction
import com.doganur.movieapp.presentation.favorite.FavoriteContract.UiEffect
import com.doganur.movieapp.presentation.favorite.FavoriteContract.UiState
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
class FavoriteViewModel @Inject constructor(
    private val deleteFavoriteMovieUseCase: DeleteFavoriteMovieUseCase,
    private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _uiEffect by lazy { Channel<UiEffect>() }
    val uiEffect: Flow<UiEffect> by lazy { _uiEffect.receiveAsFlow() }

    init {
        getFavoriteMovies()
    }

    fun onAction(uiAction: UiAction) {
        when (uiAction) {
            is UiAction.onFavoriteClick -> {
                deleteFavoriteMovie(favoriteMovie = uiAction.favoriteMovie)
            }
        }
    }

    private fun deleteFavoriteMovie(favoriteMovie: FavoriteMovie) {
        viewModelScope.launch {
            deleteFavoriteMovieUseCase(favoriteMovie = favoriteMovie)

            getFavoriteMovies()
        }
    }

    private fun getFavoriteMovies() {
        viewModelScope.launch {
            val newFavoriteList = getFavoriteMoviesUseCase()

            updateUiState {
                copy(
                    favoriteList = newFavoriteList
                )
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