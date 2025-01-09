package com.doganur.movieapp.presentation.moviedetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.doganur.movieapp.R
import com.doganur.movieapp.common.base.MyAppButton
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.presentation.theme.BlackColor
import com.doganur.movieapp.presentation.theme.UrbanistBoldTextStyle

@Composable
fun AddMovieBasketSection(
    movieModel: MovieModel,
    price: String,
    addBasketButtonClick: (MovieModel) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier,
            text = price + "₺",
            style = UrbanistBoldTextStyle.copy(
                fontSize = 30.sp,
                color = BlackColor
            )
        )

        MyAppButton(
            text = stringResource(id = R.string.add_basket),
            onClick = { addBasketButtonClick(movieModel) }
        )
    }
}

@Composable
@Preview
fun AddMovieBasketSectionPreview() {
    AddMovieBasketSection(
        price = "10.0",
        addBasketButtonClick = {},
        movieModel = MovieModel(
            id = 1,
            name = "Movie Name",
            image = "https://www.google.com",
            category = "Action",
            rating = 8.0,
            year = 2021,
            director = "Director Name",
            description = "Description",
            price = 10,
            priceStr = "10.0"
        )
    )
}