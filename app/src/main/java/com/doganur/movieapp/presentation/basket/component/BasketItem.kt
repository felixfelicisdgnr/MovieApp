package com.doganur.movieapp.presentation.basket.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.doganur.movieapp.presentation.theme.AppTheme

@Composable
fun BasketItem(
    image: String,
    name: String,
    unitPrice: String,
    orderAmount: String,
    productTotalPrice: String,
    onIncreaseButtonClick: () -> Unit,
    onDecreaseButtonClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
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
        BasketItemInfoSection(
            image = image,
            movieTitle = name,
            moviePrice = unitPrice
        )

        BasketItemControlSection(
            onIncreaseButtonClick = onIncreaseButtonClick,
            onDecreaseButtonClick = onDecreaseButtonClick,
            orderAmount = orderAmount,
            totalPrice = productTotalPrice
        )
    }
}

@Composable
@Preview
fun BasketItemPreview() {
    AppTheme {
        BasketItem(
            image = "https://image.tmdb.org/t/p/w500/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
            name = "Harry Potter",
            unitPrice = "50",
            orderAmount = "1",
            productTotalPrice = "₺ 50",
            onIncreaseButtonClick = {},
            onDecreaseButtonClick = {}
        )
    }
}
