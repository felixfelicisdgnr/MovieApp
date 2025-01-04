package com.doganur.movieapp.ui.moviedetail

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class MovieDetailScreenPreviewProvider : PreviewParameterProvider<MovieDetailContract.UiState> {
    override val values: Sequence<MovieDetailContract.UiState>
        get() = sequenceOf(
            MovieDetailContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            MovieDetailContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            MovieDetailContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}