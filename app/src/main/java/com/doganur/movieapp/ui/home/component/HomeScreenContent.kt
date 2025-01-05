package com.doganur.movieapp.ui.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.doganur.movieapp.domain.model.MovieModel

@Composable
fun HomeScreenContent(
    moviesItems: List<MovieModel> = emptyList(),
    onAddToBasketButtonClick: (MovieModel) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        MovieList(
            moviesItems = moviesItems,
            onAddToBasketButtonClick = onAddToBasketButtonClick
        )
    }
}
