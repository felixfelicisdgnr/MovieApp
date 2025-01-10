package com.doganur.movieapp.presentation.favorite.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.doganur.movieapp.data.model.FavoriteMovie

@Composable
fun FavoriteList(
    favoriteList: List<FavoriteMovie>,
    onFavoriteClick: (FavoriteMovie) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(600.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(favoriteList) { movie ->
            FavoriteItem(
                image = movie.image,
                name = movie.name,
                isFavorite = true,
                onFavoriteClick = {
                    onFavoriteClick(movie)
                }
            )
        }
    }
}

@Preview
@Composable
fun FavoriteListPreview() {
    //FavoriteList()
}