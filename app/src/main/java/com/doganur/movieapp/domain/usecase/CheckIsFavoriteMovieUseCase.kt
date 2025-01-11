package com.doganur.movieapp.domain.usecase

import com.doganur.movieapp.domain.repository.MainRepository
import javax.inject.Inject

class CheckIsFavoriteMovieUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    suspend operator fun invoke(movieId: Int): Boolean {
        return mainRepository.getFavoriteMovies().any { it.id == movieId }
    }

}