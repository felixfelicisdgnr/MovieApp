package com.doganur.movieapp.presentation.favorite

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.doganur.movieapp.presentation.favorite.FavoriteContract.UiAction
import com.doganur.movieapp.presentation.favorite.FavoriteContract.UiEffect
import com.doganur.movieapp.presentation.favorite.FavoriteContract.UiState
import com.doganur.movieapp.presentation.favorite.preview.FavoriteScreenPreviewProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun FavoriteScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    
}

@Preview(showBackground = true)
@Composable
fun FavouritesScreenPreview(
    @PreviewParameter(FavoriteScreenPreviewProvider::class) uiState: UiState,
) {
    FavoriteScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}