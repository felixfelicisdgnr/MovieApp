package com.doganur.movieapp.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Home : Screen

    @Serializable
    data object MovieDetail : Screen

    @Serializable
    data object Basket : Screen

    @Serializable
    data object Favourites : Screen

    @Serializable
    data class Profile(val id: Int) : Screen
}