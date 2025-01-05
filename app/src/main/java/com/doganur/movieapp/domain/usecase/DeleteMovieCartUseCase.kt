package com.doganur.movieapp.domain.usecase

import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.domain.repository.MainRepository
import javax.inject.Inject

class DeleteMovieCartUseCase @Inject constructor(
    private val mainRepository: MainRepository,
) {
    suspend operator fun invoke(
        cartId: Int,
    ): Resource<String> {
        return mainRepository.deleteMovieCart(
            cartId = cartId,
        )
    }
}