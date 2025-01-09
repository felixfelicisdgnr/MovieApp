package com.doganur.movieapp.presentation.basket.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.doganur.movieapp.common.base.MyAppButton
import com.doganur.movieapp.presentation.theme.UrbanistMediumTextStyle

@Composable
fun TotalBasketPriceSection(
    totalPrice: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                modifier = Modifier,
                text = "Total Price",
                style = UrbanistMediumTextStyle.copy(
                    fontSize = 20.sp,
                    color = Color.Black
                ),
            )

            Text(
                modifier = Modifier,
                text = totalPrice,
                style = UrbanistMediumTextStyle.copy(
                    fontSize = 20.sp,
                    color = Color.Black
                ),
            )
        }

        MyAppButton(
            text = "satın al",
            onClick = {}
        )
    }
}

@Composable
@Preview
fun TotalBasketPriceSectionPreview() {
    TotalBasketPriceSection(
        totalPrice = "Total Price: 100 TL"
    )
}