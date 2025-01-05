package com.doganur.movieapp.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.doganur.movieapp.domain.model.MovieModel

@Composable
fun MovieList(
    moviesItems: List<MovieModel>,
    onAddToBasketButtonClick: (MovieModel) -> Unit,
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(count = 2),
        horizontalArrangement = Arrangement.spacedBy(space = 12.dp),
        verticalArrangement = Arrangement.spacedBy(space = 9.dp)
    ) {
        items(moviesItems) { movie ->
            MovieItem(
                imageUrl = movie.image,
                movieTitle = movie.name,
                moviePrice = movie.priceStr,
                addBasketButtonClick = { onAddToBasketButtonClick(movie) }
            )
        }
    }
}