package com.doganur.movieapp.presentation.moviedetail.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import com.doganur.movieapp.common.base.components.RoundedSurface
import com.doganur.movieapp.presentation.theme.AppTheme
import com.doganur.movieapp.presentation.theme.BlackColor
import com.doganur.movieapp.presentation.theme.PrimaryColor
import com.doganur.movieapp.presentation.theme.UrbanistSemiBoldTextStyle

@Composable
fun MovieInformationChipsItem(
    text: String,
    icon: Int,
    iconDescription: String,
    iconTint : Color = Color.Black
) {
    RoundedSurface(
        modifier = Modifier,
        borderStroke = BorderStroke(1.dp, PrimaryColor),
        shape = RoundedCornerShape(10.dp),
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 10.dp
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = iconDescription,
                tint = iconTint
            )

            Text(
                text = text,
                style = UrbanistSemiBoldTextStyle.copy(
                    fontSize = 12.sp
                ),
                color = BlackColor
            )
        }
    }
}

@Preview
@Composable
fun MovieInformationChipsItemPreview() {
    AppTheme {
        MovieInformationChipsItem(
            text = stringResource(id = R.string.category),
            icon = R.drawable.ic_category,
            iconDescription = stringResource(id = R.string.cont_desc_icon_category)
        )
    }
}