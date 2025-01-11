package com.doganur.movieapp.domain.usecase

import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class DeleteMovieCartUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(
        cartId: Int,
    ): Resource<String> {
        return movieRepository.deleteMovieCart(
            cartId = cartId,
        )
    }
}