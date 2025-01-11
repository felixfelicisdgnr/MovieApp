package com.doganur.movieapp.presentation.basket.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.doganur.movieapp.common.base.components.MyAppButton
import com.doganur.movieapp.presentation.theme.AppTheme
import com.doganur.movieapp.presentation.theme.UrbanistMediumTextStyle

@Composable
fun TotalBasketPriceSection(
    totalPrice: String
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.total_price),
                style = UrbanistMediumTextStyle.copy(
                    fontSize = 20.sp,
                    color = Color.Black
                ),
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = totalPrice,
                style = UrbanistMediumTextStyle.copy(
                    fontSize = 24.sp,
                    color = Color.Black
                ),
            )
        }

        MyAppButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.confirm_basket),
            onClick = {}
        )
    }
}

@Composable
@Preview
fun TotalBasketPriceSectionPreview() {
    AppTheme {
        TotalBasketPriceSection(
            totalPrice = " 100 TL"
        )
    }
}