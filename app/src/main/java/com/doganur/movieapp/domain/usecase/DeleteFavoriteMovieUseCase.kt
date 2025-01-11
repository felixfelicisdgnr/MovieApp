package com.doganur.movieapp.domain.usecase

import com.doganur.movieapp.data.model.FavoriteMovie
import com.doganur.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class DeleteFavoriteMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(favoriteMovie: FavoriteMovie) {
        movieRepository.deleteFavorite(favoriteMovie = favoriteMovie)
    }
}