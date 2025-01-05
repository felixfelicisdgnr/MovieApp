package com.doganur.movieapp.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun MovieItem(
    imageUrl: String,
    movieTitle: String,
    moviePrice: String,
    addBasketButtonClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(135.dp)
            .height(200.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color.Green,
            disabledContentColor = Color.Gray,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        )
    ) {
        AsyncImage(
            modifier = Modifier
                .height(140.dp)
                .width(130.dp)
                .align(Alignment.CenterHorizontally),
            model = imageUrl,
            contentDescription = "stringResource(id = R.string.cont_desc_image_movie)",
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            text = movieTitle,
            color = Color.Black,
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
                color = Color.Black,
            )

            IconButton(
                onClick = { addBasketButtonClick() },
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "stringResource(id = R.string.cont_desc_icon_add)",
                    tint = Color.Black
                )
            }
        }
    }
}

