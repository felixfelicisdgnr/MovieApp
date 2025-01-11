package com.doganur.movieapp.data.model

import com.google.gson.annotations.SerializedName

data class MovieCartResponse(
    @SerializedName("movie_cart")
    val movieCartList: List<MovieCart>? = null
)
