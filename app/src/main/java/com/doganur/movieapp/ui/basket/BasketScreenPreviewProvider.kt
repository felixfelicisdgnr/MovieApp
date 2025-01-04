package com.doganur.movieapp.ui.basket

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

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
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}