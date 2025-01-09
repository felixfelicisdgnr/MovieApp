package com.doganur.movieapp.domain.mapper

import com.doganur.movieapp.common.Constants
import com.doganur.movieapp.common.orZero
import com.doganur.movieapp.data.model.GetAllMoviesResponse
import com.doganur.movieapp.domain.model.MovieModel

fun GetAllMoviesResponse?.mapToMovieModelList(): List<MovieModel> {
    return this?.movies?.map {
        MovieModel(
            id = it.id.orZero(),
            name = it.name.orEmpty(),
            image = "${Constants.BASE_IMAGE_URL}${it.image.orEmpty()}",
            price = it.price.orZero(),
            priceStr = " ₺ ${it.price.orZero()}",
            category = it.category.orEmpty(),
            rating = it.rating.orZero(),
            year = it.year.orZero(),
            director = it.director.orEmpty(),
            description = it.description.orEmpty(),
        )
    }.orEmpty()
}