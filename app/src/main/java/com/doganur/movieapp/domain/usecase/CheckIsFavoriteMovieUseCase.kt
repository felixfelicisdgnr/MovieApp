package com.doganur.movieapp.domain.usecase

import com.doganur.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class CheckIsFavoriteMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(movieId: Int): Boolean {
        return movieRepository.getFavoriteMovies().any { it.id == movieId }
    }

}