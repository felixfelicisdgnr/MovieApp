package com.doganur.movieapp.data.model

import com.doganur.movieapp.data.model.MovieCart
import com.google.gson.annotations.SerializedName

data class MovieCartAnswer(
    @SerializedName("movie_cart")
    var movie_cart: List<MovieCart>)
{
}