package com.doganur.movieapp.domain.usecase

import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.domain.model.MovieCartModel
import com.doganur.movieapp.domain.repository.MainRepository
import javax.inject.Inject

class GetBasketUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke(
        username : String
    ) : Resource<List<MovieCartModel>> {
        return mainRepository.getBasket(
            username = username
        )
    }
}