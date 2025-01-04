package com.doganur.movieapp.ui.favourites

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class FavouritesScreenPreviewProvider : PreviewParameterProvider<FavouritesContract.UiState> {
    override val values: Sequence<FavouritesContract.UiState>
        get() = sequenceOf(
            FavouritesContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            FavouritesContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            FavouritesContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}