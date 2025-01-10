package com.doganur.movieapp.presentation.favorite.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.doganur.movieapp.data.model.FavoriteMovie
import com.doganur.movieapp.presentation.theme.AppTheme

@Composable
fun FavoriteScreenContent(
    favoriteList: List<FavoriteMovie>,
    onFavoriteClick: (FavoriteMovie) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FavoriteList(
            favoriteList = favoriteList,
            onFavoriteClick = onFavoriteClick
        )
    }
}

@Preview
@Composable
fun FavoriteScreenContentPreview() {
    AppTheme {

    }
}