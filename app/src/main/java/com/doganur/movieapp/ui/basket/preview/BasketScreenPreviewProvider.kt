package com.doganur.movieapp.ui.basket.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.doganur.movieapp.domain.model.MovieCartModel
import com.doganur.movieapp.ui.basket.BasketContract

class BasketScreenPreviewProvider : PreviewParameterProvider<BasketContract.UiState> {
    override val values: Sequence<BasketContract.UiState>
        get() = sequenceOf(
            BasketContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            BasketContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            BasketContract.UiState(
                isLoading = false,
                list = listOf(
                    MovieCartModel(
                        cartId = 1,
                        name = "Movie 1",
                        image = "https://image",
                        price = 10,
                        priceStr = "₺ 10",
                        category = "Action",
                        rating = 4.5,
                        year = 2021,
                        director = "Director 1",
                        description = "Description 1",
                        orderAmount = 1,
                        orderAmountStr = "1",
                    ),
                    MovieCartModel(
                        cartId = 1,
                        name = "Movie 1",
                        image = "https://image",
                        price = 10,
                        priceStr = "₺ 10",
                        category = "Action",
                        rating = 4.5,
                        year = 2021,
                        director = "Director 1",
                        description = "Description 1",
                        orderAmount = 1,
                        orderAmountStr = "1",
                    ),
                    MovieCartModel(
                        cartId = 1,
                        name = "Movie 1",
                        image = "https://image",
                        price = 10,
                        priceStr = "₺ 10",
                        category = "Action",
                        rating = 4.5,
                        year = 2021,
                        director = "Director 1",
                        description = "Description 1",
                        orderAmount = 1,
                        orderAmountStr = "1",
                    ),
                )
            ),
        )
}