package com.doganur.movieapp.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.presentation.theme.AppTheme

@Composable
fun MovieList(
    moviesItems: List<MovieModel>,
    onAddToBasketButtonClick: (MovieModel) -> Unit,
    imageClick: (MovieModel) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth(),
        columns = GridCells.Fixed(count = 2),
        horizontalArrangement = Arrangement.spacedBy(space = 12.dp),
        verticalArrangement = Arrangement.spacedBy(space = 9.dp)
    ) {
        items(moviesItems) { movie ->
            MovieItem(
                imageUrl = movie.image,
                movieTitle = movie.name,
                moviePrice = movie.priceStr,
                addBasketButtonClick = { onAddToBasketButtonClick(movie) },
                imageClick = { imageClick(movie) }
            )
        }

        item { Spacer(modifier = Modifier.height(10.dp)) }

    }
}

@Preview
@Composable
fun MovieListPreview() {

    val movieItems = listOf(
        MovieModel(
            id = 1,
            name = "Movie 1",
            image = "https://image",
            price = 10,
            priceStr = "₺ 10",
            category = "Action",
            rating = 4.5,
            year = 2021,
            director = "Director 1",
            description = "Description 1",
        ),
        MovieModel(
            id = 2,
            name = "Movie 2",
            image = "https://image",
            price = 20,
            priceStr = "₺ 20",
            category = "Comedy",
            rating = 3.5,
            year = 2022,
            director = "Director 2",
            description = "Description 2",
        ),
        MovieModel(
            id = 3,
            name = "Movie 3",
            image = "https://image",
            price = 30,
            priceStr = "₺ 30",
            category = "Drama",
            rating = 4.0,
            year = 2023,
            director = "Director 3",
            description = "Description 3",
        ),
    )

    AppTheme {
        MovieList(
            moviesItems = movieItems,
            onAddToBasketButtonClick = {},
            imageClick = {}
        )
    }
}