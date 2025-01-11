package com.doganur.movieapp.domain.usecase

import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.domain.model.MovieCartModel
import jakarta.inject.Inject

class GetGroupedBasketUseCase @Inject constructor(
    private val getBasketUseCase: GetBasketUseCase
) {
    suspend operator fun invoke(username: String): Resource<List<MovieCartModel>> {
        return when (val result = getBasketUseCase(username)) {
            is Resource.Success -> {
                val groupedList = result.data.groupBy { it.name }
                    .map { (_, movies) ->
                        movies.first().copy(
                            orderAmount = movies.sumOf { it.orderAmount },
                            orderAmountStr = movies.sumOf { it.orderAmount }.toString()
                        )
                    }
                Resource.Success(groupedList)
            }
            is Resource.Fail -> Resource.Fail(result.message)
        }
    }
}