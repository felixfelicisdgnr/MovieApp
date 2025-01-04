package com.doganur.movieapp.domain.repository

import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.domain.model.MovieModel

interface MainRepository {
    suspend fun getAllMovies(): Resource<List<MovieModel>>
    suspend fun addBasket(
        name: String,
        image: String,
        price: Int,
        category: String,
        rating: Double,
        year: Int,
        director: String,
        description: String,
    ): Resource<String>
}