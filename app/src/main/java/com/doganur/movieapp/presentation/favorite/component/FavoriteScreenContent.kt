package com.doganur.movieapp.presentation.favorite.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun FavoriteScreenContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Favorite Content",
            fontSize = 24.sp,
        )
    }
}

@Preview
@Composable
fun FavoriteScreenContentPreview() {
    FavoriteScreenContent()
}