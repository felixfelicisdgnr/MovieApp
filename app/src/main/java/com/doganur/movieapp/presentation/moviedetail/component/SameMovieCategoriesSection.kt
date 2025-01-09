package com.doganur.movieapp.presentation.moviedetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.presentation.theme.AppTheme

@Composable
fun SameMovieCategoriesSection(
    categoryList: List<MovieModel>,
    onMovieClick : (MovieModel) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(space = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(categoryList) { movie ->
            AsyncImage(
                model = movie.image,
                contentDescription = movie.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(Color.Green)
                    .width(130.dp)
                    .height(180.dp)
                    .clickable {
                        onMovieClick(movie)
                    }
            )
        }
    }
}

@Preview
@Composable
fun SameMovieCategoriesSectionPreview() {

    val categoryList = listOf(
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
        )
    )

    AppTheme {
        SameMovieCategoriesSection(
            categoryList = categoryList,
            onMovieClick = {}
        )
    }
}