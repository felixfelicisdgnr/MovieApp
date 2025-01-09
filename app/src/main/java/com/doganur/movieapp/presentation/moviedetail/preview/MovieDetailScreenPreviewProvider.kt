package com.doganur.movieapp.presentation.moviedetail.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.doganur.movieapp.presentation.moviedetail.MovieDetailContract

class MovieDetailScreenPreviewProvider : PreviewParameterProvider<MovieDetailContract.UiState> {
    override val values: Sequence<MovieDetailContract.UiState>
        get() = sequenceOf(
            MovieDetailContract.UiState(
                isLoading = true,
                movieId = 1,
                name = "Movie Name",
                image = "Movie Image",
                price = 10,
                category = "Movie Category",
                rating = 5.0,
                year = 2021,
                director = "Movie Director",
                description = "Movie Description"
            ),
            MovieDetailContract.UiState(
                isLoading = false,
                movieId = 1,
                name = "Movie Name",
                image = "Movie Image",
                price = 10,
                category = "Movie Category",
                rating = 5.0,
                year = 2021,
                director = "Movie Director",
                description = "Movie Description"
            ),
            MovieDetailContract.UiState(
                isLoading = false,
                movieId = 1,
                name = "Movie Name",
                image = "Movie Image",
                price = 10,
                category = "Movie Category",
                rating = 5.0,
                year = 2021,
                director = "Movie Director",
                description = "Movie Description"
            ),
        )
}