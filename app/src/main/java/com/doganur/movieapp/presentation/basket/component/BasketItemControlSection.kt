package com.doganur.movieapp.presentation.basket.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doganur.movieapp.R
import com.doganur.movieapp.presentation.theme.AppTheme
import com.doganur.movieapp.presentation.theme.UrbanistBoldTextStyle

@Composable
fun BasketItemControlSection(
    orderAmount: String,
    totalPrice: String,
    onIncreaseButtonClick: () -> Unit,
    onDecreaseButtonClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(start = 6.dp, end = 6.dp, bottom = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(12.dp)
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { onDecreaseButtonClick() }
                ) {
                    Icon(
                        modifier = Modifier
                            .size(25.dp),
                        painter = painterResource(id = R.drawable.ic_decrease),
                        contentDescription = stringResource(id = R.string.cont_desc_icon_decrease)
                    )
                }

                Text(
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                    text = orderAmount,
                    style = UrbanistBoldTextStyle.copy(
                        fontSize = 20.sp,
                        color = Color.Black
                    ),
                )

                IconButton(
                    onClick = { onIncreaseButtonClick() }
                ) {
                    Icon(
                        modifier = Modifier
                            .size(25.dp),
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = stringResource(id = R.string.cont_desc_icon_add)
                    )
                }
            }
        }

        Text(
            text = totalPrice,
            style = UrbanistBoldTextStyle.copy(
                fontSize = 28.sp,
                color = Color.Black
            ),
        )
    }
}

@Preview
@Composable
fun BasketItemControlSectionPreview() {
    AppTheme {
        BasketItemControlSection(
            orderAmount = "1",
            totalPrice = "10.00",
            onIncreaseButtonClick = {},
            onDecreaseButtonClick = {}
        )
    }
}
