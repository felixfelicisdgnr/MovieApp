package com.doganur.movieapp.presentation.basket.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.doganur.movieapp.domain.model.MovieCartModel

@Composable
fun BasketScreenContent(
    basketList: List<MovieCartModel> = emptyList(),
    onIncreaseButtonClick: (MovieCartModel) -> Unit = {},
    onDecreaseButtonClick: (MovieCartModel) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        BasketList(
            basketList = basketList,
            onIncreaseButtonClick = onIncreaseButtonClick,
            onDecreaseButtonClick = onDecreaseButtonClick
        )

        TotalBasketPriceSection(
            totalPrice = basketList.sumOf {
                it.price * it.orderAmount
            }.toString()
        )
    }
}