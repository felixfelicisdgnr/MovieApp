package com.doganur.movieapp.presentation.moviedetail

object MovieDetailContract {
    data class UiState(
        val isLoading: Boolean = false,
        val movieId : Int? = null,
        val name : String? = null,
        val image : String? = null,
        val price : Int? = null,
        val category : String? = null,
        val rating : Double? = null,
        val year : Int? = null,
        val director : String? = null,
        val description : String? = null
    )

    sealed class UiAction

    sealed class UiEffect
}