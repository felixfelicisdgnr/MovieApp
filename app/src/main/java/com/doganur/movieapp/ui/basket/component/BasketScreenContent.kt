package com.doganur.movieapp.ui.basket.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.doganur.movieapp.domain.model.MovieCartModel

@Composable
fun BasketScreenContent(
    basketList: List<MovieCartModel> = emptyList(),
    onDeleteButtonClick: (MovieCartModel) -> Unit,
    onIncreaseButtonClick: (MovieCartModel) -> Unit = {},
    onDecreaseButtonClick: (MovieCartModel) -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        BasketList(
            basketList = basketList,
            onDeleteButtonClick = onDeleteButtonClick,
            onIncreaseButtonClick = onIncreaseButtonClick,
            onDecreaseButtonClick = onDecreaseButtonClick
        )
    }
}