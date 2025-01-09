package com.doganur.movieapp.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.doganur.movieapp.R
import com.doganur.movieapp.presentation.theme.AppTheme
import com.doganur.movieapp.presentation.theme.BlackColor
import com.doganur.movieapp.presentation.theme.UrbanistBoldTextStyle
import com.doganur.movieapp.presentation.theme.UrbanistSemiBoldTextStyle

@Composable
fun MovieItem(
    imageUrl: String,
    movieTitle: String,
    moviePrice: String,
    addBasketButtonClick: () -> Unit,
    imageClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(170.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color.Green,
            disabledContentColor = Color.Gray,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp,
            pressedElevation = 4.dp
        )
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = stringResource(id = R.string.cont_desc_image_movie),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(200.dp)
                .width(150.dp)
                .padding(top = 10.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Red)
                .align(Alignment.CenterHorizontally)
                .clickable {
                    imageClick()
                }
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            text = movieTitle,
            style = UrbanistSemiBoldTextStyle.copy(
                fontSize = 16.sp,
                color = BlackColor,
                textAlign = TextAlign.Center
            )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Text(
                modifier = Modifier,
                text = moviePrice,
                style = UrbanistBoldTextStyle.copy(
                    fontSize = 18.sp,
                    color = BlackColor,
                    textAlign = TextAlign.Start
                )
            )

            IconButton(
                onClick = { addBasketButtonClick() },
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = R.drawable.ic_shopping_basket),
                    contentDescription = stringResource(id = R.string.cont_desc_icon_basket),
                )
            }
        }
    }
}

@Preview
@Composable
fun MovieItemPreview() {
    AppTheme {
        MovieItem(
            imageUrl = "https://image",
            movieTitle = "Movie Name",
            moviePrice = "10.0",
            addBasketButtonClick = {},
            imageClick = {}
        )
    }
}

