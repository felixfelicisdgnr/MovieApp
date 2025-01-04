package com.doganur.movieapp.ui.favourites

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.doganur.movieapp.ui.components.EmptyScreen
import com.doganur.movieapp.ui.components.LoadingBar
import com.doganur.movieapp.ui.favourites.FavouritesContract.UiAction
import com.doganur.movieapp.ui.favourites.FavouritesContract.UiEffect
import com.doganur.movieapp.ui.favourites.FavouritesContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun FavouritesScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> FavouritesContent()
    }
}

@Composable
fun FavouritesContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Favourites Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FavouritesScreenPreview(
    @PreviewParameter(FavouritesScreenPreviewProvider::class) uiState: UiState,
) {
    FavouritesScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}