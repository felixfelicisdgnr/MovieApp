package com.doganur.movieapp.presentation.moviedetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MovieDetailScreenContent(
    name: String,
    image: String,
    category: String,
    rating: String,
    year: String,
    director: String,
    description: String,
    price : String,
    addOnBasketButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
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
            addBasketButtonClick = addOnBasketButtonClick
        )

        SameMovieCategoriesSection(
            categoryList = emptyList()
        )
    }
}

@Preview
@Composable
fun MovieDetailScreenContentPreview() {
    MovieDetailScreenContent(
        name = "Movie Name",
        image = "https://image",
        category = "Action",
        rating = "8.5",
        year = "2021",
        director = "Director Name",
        description = "DescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionvv",
        price = "10.0",
        addOnBasketButtonClick = {}
    )
}
