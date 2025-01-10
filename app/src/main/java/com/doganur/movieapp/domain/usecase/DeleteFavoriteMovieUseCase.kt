package com.doganur.movieapp.domain.usecase

import com.doganur.movieapp.data.model.FavoriteMovie
import com.doganur.movieapp.domain.repository.MainRepository
import javax.inject.Inject

class DeleteFavoriteMovieUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke(favoriteMovie: FavoriteMovie) {
        mainRepository.deleteFavorite(favoriteMovie = favoriteMovie)
    }
}