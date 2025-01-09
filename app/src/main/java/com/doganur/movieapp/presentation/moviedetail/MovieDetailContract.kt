package com.doganur.movieapp.presentation.moviedetail

import com.doganur.movieapp.domain.model.MovieModel

object MovieDetailContract {
    data class UiState(
        val isLoading: Boolean = false,
        val movieId: Int? = null,
        val name: String? = null,
        val image: String? = null,
        val price: Int? = null,
        val category: String? = null,
        val rating: Double? = null,
        val year: Int? = null,
        val director: String? = null,
        val description: String? = null,
        val similarMovies: List<MovieModel>? = null
    )

    sealed interface UiAction {

        data class OnAddToBasketClick(val movieModel: MovieModel) : UiAction
        data class OnSimilarMovieClick(val movieModel: MovieModel) : UiAction
    }

    sealed interface UiEffect {
        data class ShowToast(val message: String) : UiEffect

        data class NavigateToMovieDetail(val movieModel: MovieModel) : UiEffect
    }
}