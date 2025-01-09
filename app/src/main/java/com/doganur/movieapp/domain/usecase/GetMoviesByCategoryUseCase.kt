package com.doganur.movieapp.domain.usecase

import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.domain.repository.MainRepository
import javax.inject.Inject

class GetMoviesByCategoryUseCase @Inject constructor(
    private val repository: MainRepository
) {
    suspend operator fun invoke(category: String): Resource<List<MovieModel>> {
        return try {
            when (val allMovies = repository.getAllMovies()) {
                is Resource.Success -> {
                    val filteredMovies = if (category.isEmpty()) {
                        allMovies.data
                    } else {
                        allMovies.data.filter { it.category == category }
                    }
                    Resource.Success(filteredMovies)
                }
                is Resource.Fail -> Resource.Fail(allMovies.message)
            }
        } catch (e: Exception) {
            Resource.Fail(e.message ?: "Bir hata oluştu")
        }
    }
}