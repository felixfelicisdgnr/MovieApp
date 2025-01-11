package com.doganur.movieapp.domain.usecase

import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.common.searchQuery
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.domain.model.SortType
import com.doganur.movieapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        searchQuery: String,
        sortQuery: SortType?,
        category: String
    ): Resource<List<MovieModel>> {
        return getMovies(searchQuery, sortQuery, category)
    }

    private suspend fun getMovies(
        searchQuery: String,
        sortQuery: SortType?,
        category: String
    ): Resource<List<MovieModel>> {
        return when (val result = movieRepository.getAllMovies()) {
            is Resource.Success -> {
                val filteredName = filterMoviesByName(result.data, searchQuery)
                val filteredCategory = filterMoviesByCategory(filteredName, category)
                val sortedList = sortMovies(filteredCategory, sortQuery)
                Resource.Success(sortedList)
            }

            is Resource.Fail -> Resource.Fail(result.message)
        }
    }

    private fun filterMoviesByName(
        movies: List<MovieModel>,
        searchQuery: String
    ): List<MovieModel> {
        return movies.filter {
            searchQuery(
                searchQuery,
                it.name
            ) || searchQuery.isBlank()
        }
    }

    private fun filterMoviesByCategory(
        movies: List<MovieModel>,
        searchCategory: String
    ): List<MovieModel> {
        return movies.filter {
            it.category == searchCategory || searchCategory.isBlank()
        }
    }

    private fun sortMovies(
        movies: List<MovieModel>,
        sortQuery: SortType?
    ): List<MovieModel> {
        val sortedList = when (sortQuery) {
            SortType.PRICE_ASC -> {
                movies.sortedBy { it.price }
            }

            SortType.PRICE_DESC -> {
                movies.sortedByDescending { it.price }
            }

            SortType.NEWEST -> {
                movies.sortedByDescending { it.year }
            }

            SortType.NAME_ASC -> {
                movies.sortedBy { it.name }
            }

            SortType.NAME_DESC -> {
                movies.sortedByDescending { it.name }
            }

            SortType.RATE_ASC -> {
                movies.sortedBy { it.rating }
            }

            null -> movies
        }

        return sortedList
    }
}