package com.doganur.movieapp.presentation.favorite.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import com.doganur.movieapp.presentation.theme.BlackColor
import com.doganur.movieapp.presentation.theme.UrbanistBoldTextStyle

@Composable
fun FavoriteItem(
    image: String,
    name: String,
    isFavorite: Boolean = false,
    onFavoriteClick: () -> Unit
) {
    val iconColor = if (isFavorite) {
        Color.Red
    } else {
        Color.Black
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = Color.White),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        AsyncImage(
            modifier = Modifier
                .size(
                    width = 130.dp,
                    height = 140.dp
                )
                .padding(all = 10.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = BlackColor),
            model = image,
            contentDescription = stringResource(id = R.string.cont_desc_image_movie),
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier
                .padding(all = 10.dp),
            text = name,
            style = UrbanistBoldTextStyle.copy(
                fontSize = 20.sp,
                color = BlackColor,
                textAlign = TextAlign.Start
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            painter = painterResource(id = R.drawable.ic_favorite),
            contentDescription = stringResource(id = R.string.cont_desc_icon_favorite),
            tint = iconColor,
            modifier = Modifier
                .padding(all = 10.dp)
                .size(35.dp)
                .clickable {
                    onFavoriteClick()
                },
        )
    }
}

@Preview
@Composable
fun FavoriteItemPreview() {
    FavoriteItem(
        image = "https://www.google.com",
        name = "Movie Name",
        onFavoriteClick = {},
        isFavorite = true
    )
}