package com.doganur.movieapp.presentation.basket

import com.doganur.movieapp.domain.model.MovieCartModel

object BasketContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<MovieCartModel> = emptyList(),
    )

    sealed interface UiAction {
        data class OnIncreaseButtonClick(val movieCartModel: MovieCartModel) : UiAction
        data class OnDecreaseButtonClick(val movieCartModel: MovieCartModel) : UiAction
    }

    sealed interface UiEffect {
        data class ShowToast(val message: String) : UiEffect
    }
}