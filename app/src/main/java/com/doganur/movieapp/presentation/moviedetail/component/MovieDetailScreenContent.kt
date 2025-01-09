package com.doganur.movieapp.presentation.moviedetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.doganur.movieapp.R
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.presentation.theme.AppTheme
import com.doganur.movieapp.presentation.theme.BlackColor
import com.doganur.movieapp.presentation.theme.UrbanistBoldTextStyle

@Composable
fun MovieDetailScreenContent(
    movieId : Int,
    name: String,
    image: String,
    category: String,
    rating: String,
    year: String,
    director: String,
    description: String,
    price : String,
    similarMovies : List<MovieModel>,
    addOnBasketButtonClick: (MovieModel) -> Unit,
    onSimilarMovieClick: (MovieModel) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        MovieInformationSection(
            name = name,
            image = image,
            category = category,
            rating = rating,
            year = year,
            director = director,
            description = description
        )


        AddMovieBasketSection(
            price = price,
            addBasketButtonClick = addOnBasketButtonClick,
            movieModel = MovieModel(
                id = movieId,
                name = name,
                image = image,
                category = category,
                rating = rating.toDouble(),
                year = year.toInt(),
                director = director,
                description = description,
                price = price.toInt(),
                priceStr = price
            )
        )

        MovieInformationChipsMenu(
            category = category,
            rating = rating,
            year = year,
            director = director
        )

        Text(
            text = stringResource(id = R.string.similar_movies),
            style = UrbanistBoldTextStyle.copy(
                fontSize = 24.sp,
                color = BlackColor
            )
        )

        SameMovieCategoriesSection(
            categoryList = similarMovies,
            onMovieClick = onSimilarMovieClick
        )
    }
}

@Preview
@Composable
fun MovieDetailScreenContentPreview() {

    val similarMovies = listOf(
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
        MovieDetailScreenContent(
            name = "Movie Name",
            image = "https://image",
            category = "Action",
            rating = "8.5",
            year = "2021",
            director = "Director Name",
            description = "DescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionvv",
            price = "10.0",
            addOnBasketButtonClick = {},
            similarMovies = similarMovies,
            onSimilarMovieClick = {},
            movieId = 1
        )
    }
}
