package com.doganur.movieapp.domain.usecase

import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.domain.repository.MainRepository
import javax.inject.Inject

class SearchMoviesByNameUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke(
        searchQuery: String
    ): Resource<List<MovieModel>> {
        return  mainRepository.getAllMovies()
    }
}