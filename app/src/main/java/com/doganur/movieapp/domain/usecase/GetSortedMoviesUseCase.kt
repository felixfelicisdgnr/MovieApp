package com.doganur.movieapp.domain.usecase

import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.domain.model.SortType
import javax.inject.Inject

class GetSortedMoviesUseCase @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
) {
    suspend operator fun invoke(sortType: SortType): Resource<List<MovieModel>> {
        return when (val result = getAllMoviesUseCase()) {
            is Resource.Success -> {
                val sortedList = when (sortType) {
                    SortType.PRICE_ASC -> {
                        result.data.sortedBy { it.price }
                    }
                    SortType.PRICE_DESC -> {
                        result.data.sortedByDescending { it.price }
                    }
                    SortType.NEWEST -> {
                        result.data.sortedByDescending { it.year }
                    }
                    SortType.NAME_ASC -> {
                        result.data.sortedBy { it.name }
                    }
                    SortType.NAME_DESC -> {
                        result.data.sortedByDescending { it.name }
                    }
                    SortType.RATE_ASC -> {
                        result.data.sortedBy { it.rating }
                    }
                }
                Resource.Success(sortedList)
            }
            is Resource.Fail -> Resource.Fail(result.message)
        }
    }
}