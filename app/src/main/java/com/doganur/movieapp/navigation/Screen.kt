package com.doganur.movieapp.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Home : Screen

    @Serializable
    data class MovieDetail(
        val movieId: Int,
        val name: String,
        val image: String,
        val price: Int,
        val category: String,
        val rating: Double,
        val year: Int,
        val director: String,
        val description: String
    ) : Screen

    @Serializable
    data object Basket : Screen

    @Serializable
    data object Favorite : Screen
}