package com.doganur.movieapp.presentation.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.doganur.movieapp.common.base.components.EmptyFavoriteScreen
import com.doganur.movieapp.common.base.components.LoadingBar
import com.doganur.movieapp.presentation.favorite.FavoriteContract.UiAction
import com.doganur.movieapp.presentation.favorite.FavoriteContract.UiEffect
import com.doganur.movieapp.presentation.favorite.FavoriteContract.UiState
import com.doganur.movieapp.presentation.favorite.component.FavoriteScreenContent
import com.doganur.movieapp.presentation.favorite.preview.FavoriteScreenPreviewProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun FavoriteScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(8.dp))
            .padding(vertical = 10.dp),
        contentAlignment = Alignment.Center,
    ) {
        if (uiState.favoriteList.isEmpty() && !uiState.isLoading) {
            EmptyFavoriteScreen()
        } else {
            FavoriteScreenContent(
                favoriteList = uiState.favoriteList,
                onFavoriteClick = { onAction(UiAction.onFavoriteClick(it)) }
            )
        }

        if (uiState.isLoading) LoadingBar()
    }
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