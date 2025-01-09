package com.doganur.movieapp.presentation.home

import com.doganur.movieapp.common.EMPTY
import com.doganur.movieapp.domain.model.MovieModel

object HomeContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<MovieModel> = emptyList(),
        val selectedCategory: String = String.EMPTY,
        val searchText: String = String.EMPTY
    )

    sealed interface UiAction {
        data class OnAddToBasketClick(val movieModel: MovieModel) : UiAction
        data class OnMovieItemClick(val movieModel: MovieModel) : UiAction
        data class OnCategoryClick(val category: String) : UiAction
        data class OnSearchValueChange(val searchText: String) : UiAction
    }

    sealed interface UiEffect {
        data class ShowToast(val message: String) : UiEffect

        data class NavigateToMovieDetail(val movieModel: MovieModel) : UiEffect
    }
}