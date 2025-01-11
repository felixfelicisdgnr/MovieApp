package com.doganur.movieapp.presentation.home

import com.doganur.movieapp.common.EMPTY
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.domain.model.SortType

object HomeContract {
    data class UiState(
        val isLoading: Boolean = false,
        val movies: List<MovieModel> = emptyList(),
        val categories: List<String> = emptyList(),
        val selectedCategory: String = String.EMPTY,
        val searchText: String = String.EMPTY,
        val selectedSortType: SortType = SortType.NEWEST
    )

    sealed interface UiAction {
        data class OnAddToBasketClick(val movieModel: MovieModel) : UiAction
        data class OnMovieItemClick(val movieModel: MovieModel) : UiAction
        data class OnCategoryClick(val category: String) : UiAction
        data class OnSearchValueChange(val searchText: String) : UiAction
        data class OnSortTypeChange(val sortType: SortType) : UiAction
    }

    sealed interface UiEffect {
        data class ShowToast(val message: String) : UiEffect

        data class NavigateToMovieDetail(val movieModel: MovieModel) : UiEffect
    }
}