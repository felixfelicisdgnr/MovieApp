package com.doganur.movieapp.domain.usecase

import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.domain.model.MovieCartModel
import com.doganur.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetBasketUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        username : String
    ) : Resource<List<MovieCartModel>> {
        return movieRepository.getBasket(
            username = username
        )
    }
}