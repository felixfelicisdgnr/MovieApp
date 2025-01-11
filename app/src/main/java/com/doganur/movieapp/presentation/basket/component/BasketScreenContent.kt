package com.doganur.movieapp.presentation.basket.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doganur.movieapp.R
import com.doganur.movieapp.domain.model.MovieCartModel
import com.doganur.movieapp.presentation.theme.UrbanistBoldTextStyle

@Composable
fun BasketScreenContent(
    basketList: List<MovieCartModel> = emptyList(),
    onIncreaseButtonClick: (MovieCartModel) -> Unit = {},
    onDecreaseButtonClick: (MovieCartModel) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            text = stringResource(id = R.string.basket),
            style = UrbanistBoldTextStyle.copy(
                fontSize = 24.sp,
                color = Color.Black
            )
        )

        BasketList(
            basketList = basketList,
            onIncreaseButtonClick = onIncreaseButtonClick,
            onDecreaseButtonClick = onDecreaseButtonClick
        )

        Spacer(modifier = Modifier.height(10.dp))

        TotalBasketPriceSection(
            totalPrice = "₺" + basketList.sumOf {
                it.price * it.orderAmount
            }.toString()
        )
    }
}