package com.doganur.movieapp.presentation.home.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.presentation.home.HomeContract

class HomeScreenPreviewProvider : PreviewParameterProvider<HomeContract.UiState> {
    override val values: Sequence<HomeContract.UiState>
        get() = sequenceOf(
            HomeContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            HomeContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            HomeContract.UiState(
                isLoading = false,
                list = listOf(
                    MovieModel(
                        id = 1,
                        name = "Movie 1",
                        image = "https://image",
                        price = 10,
                        priceStr = "₺ 10",
                        category = "Action",
                        rating = 4.5,
                        year = 2021,
                        director = "Director 1",
                        description = "Description 1",
                    ),
                    MovieModel(
                        id = 2,
                        name = "Movie 2",
                        image = "https://image",
                        price = 20,
                        priceStr = "₺ 20",
                        category = "Comedy",
                        rating = 3.5,
                        year = 2022,
                        director = "Director 2",
                        description = "Description 2",
                    ),
                    MovieModel(
                        id = 3,
                        name = "Movie 3",
                        image = "https://image",
                        price = 30,
                        priceStr = "₺ 30",
                        category = "Drama",
                        rating = 4.0,
                        year = 2023,
                        director = "Director 3",
                        description = "Description 3",
                    ),
                )
            ),
        )
}