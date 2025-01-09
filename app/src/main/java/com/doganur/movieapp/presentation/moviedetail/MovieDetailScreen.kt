package com.doganur.movieapp.presentation.moviedetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.presentation.components.EmptyScreen
import com.doganur.movieapp.presentation.components.LoadingBar
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
    navigateToMovieDetail: (MovieModel) -> Unit // Yeni eklenen parametre
) {
    LaunchedEffect(key1 = true) {
        uiEffect.collect { effect ->
            when (effect) {
                is UiEffect.ShowToast -> {
                    // Toast mesajını göster
                }
                is UiEffect.NavigateToMovieDetail -> {
                    // Yeni film detayına git
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
                name = uiState.name ?: "",
                image = uiState.image ?: "",
                price = uiState.price.toString(),
                category = uiState.category ?: "",
                rating = uiState.rating.toString(),
                year = uiState.year.toString(),
                director = uiState.director ?: "",
                description = uiState.description ?: "",
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


@Composable
fun MovieDetailScreenTestContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Movie Detail Content",
            fontSize = 24.sp,
        )
    }
}