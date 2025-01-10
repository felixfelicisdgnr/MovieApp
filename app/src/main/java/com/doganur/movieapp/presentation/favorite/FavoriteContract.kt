package com.doganur.movieapp.presentation.favorite

import com.doganur.movieapp.data.model.FavoriteMovie

object FavoriteContract {
    data class UiState(
        val isLoading: Boolean = false,
        val favoriteList: List<FavoriteMovie> = emptyList(),
    )

    sealed interface UiAction {
        data class onFavoriteClick(val favoriteMovie: FavoriteMovie) : UiAction
    }

    sealed interface UiEffect
}