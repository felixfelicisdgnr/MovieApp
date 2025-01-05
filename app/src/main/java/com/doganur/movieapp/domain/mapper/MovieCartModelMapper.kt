package com.doganur.movieapp.domain.mapper

import com.doganur.movieapp.common.orZero
import com.doganur.movieapp.data.model.MovieCartResponse
import com.doganur.movieapp.domain.model.MovieCartModel

fun MovieCartResponse?.mapToMovieCartModelList(): List<MovieCartModel> {
    return this?.movieCartList?.map { movieCart ->
        MovieCartModel(
            cartId = movieCart.cartId.orZero(),
            name = movieCart.name.orEmpty(),
            image = movieCart.image.orEmpty(),
            price = movieCart.price.orZero(),
            priceStr = "₺ ${movieCart.price}",
            category = movieCart.category.orEmpty(),
            rating = movieCart.rating.orZero(),
            year = movieCart.year.orZero(),
            director = movieCart.director.orEmpty(),
            description = movieCart.description.orEmpty(),
            orderAmount = movieCart.orderAmount.orZero(),
            orderAmountStr = "${movieCart.orderAmount}"
        )
    }.orEmpty()
}
