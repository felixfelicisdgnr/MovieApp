package com.doganur.movieapp.presentation.favorite.component

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doganur.movieapp.R
import com.doganur.movieapp.data.model.FavoriteMovie
import com.doganur.movieapp.presentation.theme.AppTheme
import com.doganur.movieapp.presentation.theme.UrbanistBoldTextStyle

@Composable
fun FavoriteScreenContent(
    favoriteList: List<FavoriteMovie>,
    onFavoriteClick: (FavoriteMovie) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
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

        FavoriteList(
            favoriteList = favoriteList,
            onFavoriteClick = onFavoriteClick
        )
    }
}

@Preview
@Composable
fun FavoriteScreenContentPreview() {
    AppTheme {

    }
}