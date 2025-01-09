package com.doganur.movieapp.presentation.basket.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.doganur.movieapp.domain.model.MovieCartModel
import com.doganur.movieapp.presentation.theme.AppTheme
import com.doganur.movieapp.presentation.theme.PrimaryColor

@Composable
fun BasketList(
    basketList: List<MovieCartModel>,
    onDeleteButtonClick: (MovieCartModel) -> Unit = {},
    onIncreaseButtonClick: (MovieCartModel) -> Unit = {},
    onDecreaseButtonClick: (MovieCartModel) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(PrimaryColor)
            .height(700.dp)
            .padding(all = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item { Spacer(modifier = Modifier.height(10.dp)) }

        itemsIndexed(basketList) { _, item ->
            BasketItem(
                image = item.image,
                name = item.name,
                unitPrice = item.priceStr,
                orderAmount = item.orderAmountStr,
                totalPrice = item.priceStr,
                onDeleteButtonClick = { onDeleteButtonClick(item) },
                onIncreaseButtonClick = { onIncreaseButtonClick(item) },
                onDecreaseButtonClick = { onDecreaseButtonClick(item) }
            )
        }

        item { Spacer(modifier = Modifier.height(10.dp)) }
    }
}

@Preview
@Composable
fun BasketListPreview() {
    val basketList = listOf(
        MovieCartModel(
            cartId = 1,
            name = "Movie 1",
            image = "https://image.tm",
            price = 10,
            priceStr = "10.00",
            category = "Action",
            rating = 4.5,
            year = 2021,
            director = "Director 1",
            description = "Description 1",
            orderAmount = 1,
            orderAmountStr = "1"
        ),
        MovieCartModel(
            cartId = 1,
            name = "Movie 1",
            image = "https://image.tm",
            price = 10,
            priceStr = "10.00",
            category = "Action",
            rating = 4.5,
            year = 2021,
            director = "Director 1",
            description = "Description 1",
            orderAmount = 1,
            orderAmountStr = "1"
        ),
        MovieCartModel(
            cartId = 1,
            name = "Movie 1",
            image = "https://image.tm",
            price = 10,
            priceStr = "10.00",
            category = "Action",
            rating = 4.5,
            year = 2021,
            director = "Director 1",
            description = "Description 1",
            orderAmount = 1,
            orderAmountStr = "1"
        ),
        MovieCartModel(
            cartId = 1,
            name = "Movie 1",
            image = "https://image.tm",
            price = 10,
            priceStr = "10.00",
            category = "Action",
            rating = 4.5,
            year = 2021,
            director = "Director 1",
            description = "Description 1",
            orderAmount = 1,
            orderAmountStr = "1"
        ),
        MovieCartModel(
            cartId = 1,
            name = "Movie 1",
            image = "https://image.tm",
            price = 10,
            priceStr = "10.00",
            category = "Action",
            rating = 4.5,
            year = 2021,
            director = "Director 1",
            description = "Description 1",
            orderAmount = 1,
            orderAmountStr = "1"
        )
    )

    AppTheme {
        BasketList(
            basketList = basketList
        )
    }
}