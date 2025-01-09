package com.doganur.movieapp.presentation.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doganur.movieapp.common.base.RoundedSurface
import com.doganur.movieapp.presentation.theme.BlackColor
import com.doganur.movieapp.presentation.theme.PrimaryColor
import com.doganur.movieapp.presentation.theme.UrbanistSemiBoldTextStyle

@Composable
fun ChipsMenuItem(
    isSelected: Boolean,
    chipTitle: String,
    cornerRadius: Dp,
    fontSize: TextUnit,
    selectedTextColor: Color,
    selectedBorderStroke: BorderStroke,
    unselectedTextColor: Color,
    unselectedBorderStroke: BorderStroke,
    selectedBackgroundColor: Color,
    unselectedBackgroundColor: Color,
    onClick: () -> Unit
) {
    val chipsTextColor = if (isSelected) selectedTextColor else unselectedTextColor
    val backgroundColor = if (isSelected) selectedBackgroundColor else unselectedBackgroundColor
    val borderStroke = if (isSelected) selectedBorderStroke else unselectedBorderStroke

    RoundedSurface(
        modifier = Modifier
            .clip(RoundedCornerShape(cornerRadius))
            .clickable(onClick = onClick),
        borderStroke = borderStroke,
        shape = RoundedCornerShape(cornerRadius),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 10.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = chipTitle,
                style = UrbanistSemiBoldTextStyle.copy(
                    fontSize = fontSize
                ),
                color = chipsTextColor
            )
        }
    }
}

@Preview
@Composable
fun ChipsMenuItemPreview() {
    Column {
        ChipsMenuItem(
            isSelected = false,
            chipTitle = "Kamp Alanları",
            cornerRadius = 30.dp,
            fontSize = 14.sp,
            selectedTextColor = Color.White,
            selectedBorderStroke = BorderStroke(1.5.dp, PrimaryColor),
            selectedBackgroundColor = PrimaryColor,
            unselectedTextColor = BlackColor,
            unselectedBorderStroke = BorderStroke(1.5.dp, BlackColor),
            unselectedBackgroundColor = Color.Transparent,
            onClick = {}
        )

        Spacer(modifier = Modifier.height(8.dp))

        ChipsMenuItem(
            isSelected = false,
            chipTitle = "Şehir Seç",
            cornerRadius = 8.dp,
            fontSize = 12.sp,
            selectedTextColor = Color.White,
            selectedBorderStroke = BorderStroke(1.dp, PrimaryColor),
            selectedBackgroundColor = PrimaryColor,
            unselectedTextColor = BlackColor,
            unselectedBorderStroke = BorderStroke(1.dp, BlackColor),
            unselectedBackgroundColor = Color.Transparent,
            onClick = {}
        )
    }
}





