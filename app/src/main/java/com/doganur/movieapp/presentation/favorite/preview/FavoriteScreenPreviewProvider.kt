package com.doganur.movieapp.presentation.favorite.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.doganur.movieapp.data.model.FavoriteMovie
import com.doganur.movieapp.presentation.favorite.FavoriteContract

class FavoriteScreenPreviewProvider : PreviewParameterProvider<FavoriteContract.UiState> {
    override val values: Sequence<FavoriteContract.UiState>
        get() = sequenceOf(
            FavoriteContract.UiState(
                isLoading = true,
                favoriteList = listOf(
                    FavoriteMovie(
                        id = 1,
                        name = "Movie 1",
                        image = "https://image",
                        category = "Action",
                        rating = 8.0,
                        year = 2021,
                        director = "Director 1",
                        description = "Description 1"
                    ),
                    FavoriteMovie(
                        id = 1,
                        name = "Movie 1",
                        image = "https://image",
                        category = "Action",
                        rating = 8.0,
                        year = 2021,
                        director = "Director 1",
                        description = "Description 1"
                    ),
                    FavoriteMovie(
                        id = 1,
                        name = "Movie 1",
                        image = "https://image",
                        category = "Action",
                        rating = 8.0,
                        year = 2021,
                        director = "Director 1",
                        description = "Description 1"
                    ),
                    FavoriteMovie(
                        id = 1,
                        name = "Movie 1",
                        image = "https://image",
                        category = "Action",
                        rating = 8.0,
                        year = 2021,
                        director = "Director 1",
                        description = "Description 1"
                    )
                ),
            ),
            FavoriteContract.UiState(
                isLoading = false,
                favoriteList = listOf(
                    FavoriteMovie(
                        id = 1,
                        name = "Movie 1",
                        image = "https://image",
                        category = "Action",
                        rating = 8.0,
                        year = 2021,
                        director = "Director 1",
                        description = "Description 1"
                    ),
                    FavoriteMovie(
                        id = 1,
                        name = "Movie 1",
                        image = "https://image",
                        category = "Action",
                        rating = 8.0,
                        year = 2021,
                        director = "Director 1",
                        description = "Description 1"
                    ),
                    FavoriteMovie(
                        id = 1,
                        name = "Movie 1",
                        image = "https://image",
                        category = "Action",
                        rating = 8.0,
                        year = 2021,
                        director = "Director 1",
                        description = "Description 1"
                    ),
                    FavoriteMovie(
                        id = 1,
                        name = "Movie 1",
                        image = "https://image",
                        category = "Action",
                        rating = 8.0,
                        year = 2021,
                        director = "Director 1",
                        description = "Description 1"
                    )
                ),
            ),
            FavoriteContract.UiState(
                isLoading = false,
                favoriteList = listOf(
                    FavoriteMovie(
                        id = 1,
                        name = "Movie 1",
                        image = "https://image",
                        category = "Action",
                        rating = 8.0,
                        year = 2021,
                        director = "Director 1",
                        description = "Description 1"
                    ),
                    FavoriteMovie(
                        id = 1,
                        name = "Movie 1",
                        image = "https://image",
                        category = "Action",
                        rating = 8.0,
                        year = 2021,
                        director = "Director 1",
                        description = "Description 1"
                    ),
                    FavoriteMovie(
                        id = 1,
                        name = "Movie 1",
                        image = "https://image",
                        category = "Action",
                        rating = 8.0,
                        year = 2021,
                        director = "Director 1",
                        description = "Description 1"
                    ),
                    FavoriteMovie(
                        id = 1,
                        name = "Movie 1",
                        image = "https://image",
                        category = "Action",
                        rating = 8.0,
                        year = 2021,
                        director = "Director 1",
                        description = "Description 1"
                    )
                )
            ),
        )
}