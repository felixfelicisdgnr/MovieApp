package com.doganur.movieapp.presentation.moviedetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.doganur.movieapp.common.EMPTY
import com.doganur.movieapp.common.base.components.EmptyScreen
import com.doganur.movieapp.common.base.components.LoadingBar
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.presentation.moviedetail.MovieDetailContract.UiAction
import com.doganur.movieapp.presentation.moviedetail.MovieDetailContract.UiEffect
import com.doganur.movieapp.presentation.moviedetail.MovieDetailContract.UiState
import com.doganur.movieapp.presentation.moviedetail.component.MovieDetailScreenContent
import com.doganur.movieapp.presentation.moviedetail.preview.MovieDetailScreenPreviewProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun MovieDetailScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
    navigateToMovieDetail: (MovieModel) -> Unit
) {
    LaunchedEffect(key1 = true) {
        uiEffect.collect { effect ->
            when (effect) {
                is UiEffect.ShowToast -> {
                }

                is UiEffect.NavigateToMovieDetail -> {
                    navigateToMovieDetail(effect.movieModel)
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        if (uiState.movieId == null
            && uiState.name == null
            && uiState.image == null
            && uiState.price == null
            && uiState.category == null
            && uiState.rating == null
            && uiState.year == null
            && uiState.director == null
            && uiState.description == null
            && !uiState.isLoading
        ) {
            EmptyScreen()
        } else {
            MovieDetailScreenContent(
                movieId = uiState.movieId ?: 0,
                name = uiState.name ?: String.EMPTY,
                image = uiState.image ?: String.EMPTY,
                price = uiState.price.toString(),
                category = uiState.category ?: String.EMPTY,
                rating = uiState.rating.toString(),
                year = uiState.year.toString(),
                director = uiState.director ?: String.EMPTY,
                description = uiState.description ?: String.EMPTY,
                addOnBasketButtonClick = { onAction(UiAction.OnAddToBasketClick(movieModel = it)) },
                similarMovies = uiState.similarMovies ?: emptyList(),
                onSimilarMovieClick = { onAction(UiAction.OnSimilarMovieClick(it)) },
            )
        }

        if (uiState.isLoading) LoadingBar()
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
        navigateToMovieDetail = { }
    )
}
