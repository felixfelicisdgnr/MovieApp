package com.doganur.movieapp.presentation.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doganur.movieapp.presentation.theme.AppTheme
import com.doganur.movieapp.presentation.theme.PrimaryColor

@Composable
fun CategoryChipsMenu(
    categoryList: List<String> = emptyList(),
    onCategoryClick: (String) -> Unit,
    isSelected: (String) -> Boolean
) {
    val lazyListState = rememberLazyListState()

    val isAtEnd = remember {
        derivedStateOf {
            lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == lazyListState.layoutInfo.totalItemsCount - 1
        }
    }

    LazyRow(
        state = lazyListState,
        modifier = Modifier
            .graphicsLayer { compositingStrategy = CompositingStrategy.Offscreen }
            .drawWithContent {
                drawContent()

                if (!isAtEnd.value) {
                    val colors = listOf(Color.Black, Color.Transparent)
                    val width = size.width
                    val fadeWidthPx = 50.dp.toPx()

                    drawRect(
                        brush = Brush.horizontalGradient(
                            colors = colors,
                            startX = width - fadeWidthPx,
                            endX = width
                        ),
                        blendMode = BlendMode.DstIn
                    )
                }
            },
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        categoryList.forEach { movieCategory ->
            item {
                ChipsMenuItem(
                    isSelected = isSelected(movieCategory),
                    chipTitle = movieCategory,
                    cornerRadius = 30.dp,
                    fontSize = 14.sp,
                    selectedTextColor = Color.White,
                    selectedBorderStroke = BorderStroke(1.5.dp, PrimaryColor),
                    selectedBackgroundColor = PrimaryColor,
                    unselectedTextColor = Color.Gray,
                    unselectedBorderStroke = BorderStroke(1.5.dp, PrimaryColor),
                    unselectedBackgroundColor = Color.Transparent,
                    onClick = {
                        onCategoryClick(movieCategory)
                    }
                )
            }
        }
        item {
            Spacer(modifier = Modifier.width(3.dp))
        }
    }
}


@Composable
@Preview
fun CategoryChipsMenuPreview() {
    AppTheme {
        CategoryChipsMenu(
            categoryList = listOf("Action", "Comedy", "Drama", "Horror", "Sci-Fi"),
            onCategoryClick = {},
            isSelected = { false }
        )
    }
}