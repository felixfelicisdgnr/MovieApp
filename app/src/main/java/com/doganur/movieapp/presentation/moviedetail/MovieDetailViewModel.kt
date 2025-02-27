package com.doganur.movieapp.presentation.moviedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.data.model.FavoriteMovie
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.domain.usecase.AddBasketUseCase
import com.doganur.movieapp.domain.usecase.AddMovieToFavoriteUseCase
import com.doganur.movieapp.domain.usecase.CheckIsFavoriteMovieUseCase
import com.doganur.movieapp.domain.usecase.DeleteFavoriteMovieUseCase
import com.doganur.movieapp.domain.usecase.GetMoviesUseCase
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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMoviesUseCase: GetMoviesUseCase,
    private val addBasketUseCase: AddBasketUseCase,
    private val addFavoriteMoviesUseCase: AddMovieToFavoriteUseCase,
    private val deleteFavoriteMovieUseCase: DeleteFavoriteMovieUseCase,
    private val checkIsFavoriteMovieUseCase: CheckIsFavoriteMovieUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _uiEffect by lazy { Channel<UiEffect>() }
    val uiEffect: Flow<UiEffect> by lazy { _uiEffect.receiveAsFlow() }

    init {
        val movieDetail: Screen.MovieDetail = savedStateHandle.toRoute()

        updateUiState {
            copy(
                movieId = movieDetail.movieId,
                name = movieDetail.name,
                image = movieDetail.image,
                price = movieDetail.price,
                category = movieDetail.category,
                rating = movieDetail.rating,
                year = movieDetail.year,
                director = movieDetail.director,
                description = movieDetail.description
            )
        }

        updateFavoriteState()
        getSimilarMovies(movieDetail.category)
    }

    fun onAction(uiAction: UiAction) {
        when (uiAction) {
            is UiAction.OnSimilarMovieClick -> {
                viewModelScope.launch {
                    _uiEffect.send(UiEffect.NavigateToMovieDetail(uiAction.movieModel))
                }
            }

            is UiAction.OnAddToBasketClick -> addToBasket(uiAction.movieModel)

            is UiAction.OnChangeFavoriteMovieClick -> changeFavoriteState(uiAction.favoriteMovie)
        }
    }

    private fun getSimilarMovies(category: String) = viewModelScope.launch {
        updateUiState { copy(isLoading = true) }

        when (val result = getMoviesUseCase("", null, category)) {
            is Resource.Success -> {
                val filteredMovies =
                    result.data.filter { it.id != uiState.value.movieId }  // Mevcut filmi benzer filmler listesinden çıkar

                updateUiState {
                    copy(
                        similarMovies = filteredMovies,
                        isLoading = false
                    )
                }
            }

            is Resource.Fail -> {
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

    private fun changeFavoriteState(favoriteMovie: FavoriteMovie) {
        viewModelScope.launch {
            if(uiState.value.isFavorite) {
                deleteFavoriteMovieUseCase(favoriteMovie = favoriteMovie)
            } else {
                addFavoriteMoviesUseCase(favoriteMovie = favoriteMovie)
            }

            updateFavoriteState()
        }
    }

    private fun updateFavoriteState(){
        viewModelScope.launch {
            val isFavorite = checkIsFavoriteMovieUseCase(uiState.value.movieId!!)
            updateUiState {
                copy(isFavorite = isFavorite)
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