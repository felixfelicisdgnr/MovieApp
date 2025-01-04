package com.doganur.movieapp.ui.moviedetail

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
import com.doganur.movieapp.ui.moviedetail.MovieDetailContract.UiAction
import com.doganur.movieapp.ui.moviedetail.MovieDetailContract.UiEffect
import com.doganur.movieapp.ui.moviedetail.MovieDetailContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun MovieDetailScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> MovieDetailContent()
    }
}

@Composable
fun MovieDetailContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "MovieDetail Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailScreenPreview(
    @PreviewParameter(MovieDetailScreenPreviewProvider::class) uiState: UiState,
) {
    MovieDetailScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}