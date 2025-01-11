package com.doganur.movieapp.presentation.basket.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.doganur.movieapp.R
import com.doganur.movieapp.presentation.theme.AppTheme
import com.doganur.movieapp.presentation.theme.UrbanistMediumTextStyle
import com.doganur.movieapp.presentation.theme.UrbanistRegularTextStyle

@Composable
fun BasketItemInfoSection(
    image: String,
    movieTitle: String,
    moviePrice: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 6.dp)
            .height(100.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Gray)
                .width(100.dp),
            model = image,
            contentDescription = stringResource(id = R.string.cont_desc_image_movie),
            contentScale = ContentScale.Crop
        )

        Column(
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier,
                text = movieTitle,
                style = UrbanistMediumTextStyle.copy(
                    color = Color.Black,
                    fontSize = 23.sp,
                    textAlign = TextAlign.Start
                )
            )

            Text(
                modifier = Modifier,
                text = stringResource(id = R.string.unit_price) + moviePrice,
                style = UrbanistRegularTextStyle.copy(
                    color = Color.Black,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start
                )
            )
        }
    }
}

@Preview
@Composable
fun BasketItemInfoSectionPreview() {
    AppTheme {
        BasketItemInfoSection(
            image = "https://image.tmdb.org/t/p/w500/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
            movieTitle = "Harry Potter",
            moviePrice = "10.00"
        )
    }
}