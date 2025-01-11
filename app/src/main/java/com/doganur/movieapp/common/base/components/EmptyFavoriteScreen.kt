package com.doganur.movieapp.common.base.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doganur.movieapp.R
import com.doganur.movieapp.presentation.theme.UrbanistBoldTextStyle

@Composable
fun EmptyFavoriteScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            text = stringResource(id = R.string.favorite_movie),
            style = UrbanistBoldTextStyle.copy(
                fontSize = 24.sp,
                color = Color.Black
            )
        )

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.no_favorite_movie),
            style = UrbanistBoldTextStyle.copy(
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
@Preview
fun EmptyFavoriteScreenPreview() {
    EmptyFavoriteScreen()
}