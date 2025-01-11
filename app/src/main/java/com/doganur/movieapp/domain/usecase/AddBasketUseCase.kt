package com.doganur.movieapp.domain.usecase

import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class AddBasketUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(
        name: String,
        image: String,
        price: Int,
        category: String,
        rating: Double,
        year: Int,
        director: String,
        description: String,
    ): Resource<String> {
        return movieRepository.addBasket(
            name = name,
            image = image,
            price = price,
            category = category,
            rating = rating,
            year = year,
            director = director,
            description = description,
        )
    }
}