package com.doganur.movieapp.data.model

import com.google.gson.annotations.SerializedName

data class GetAllMoviesResponse(
    @SerializedName("movies")
    val movies: List<Movie>? = null
)