package com.doganur.movieapp.presentation.moviedetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.doganur.movieapp.R

@Composable
fun MovieInformationChipsMenu(
    category: String,
    rating: String,
    year: String,
    director: String
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
                    val fadeWidthPx = 60.dp.toPx()

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
        item { Spacer(modifier = Modifier.padding(start = 1.dp)) }

        item {
            MovieInformationChipsItem(
                text = category,
                icon = R.drawable.ic_category,
                iconDescription = stringResource(id = R.string.cont_desc_icon_category)
            )
        }
        item {
            MovieInformationChipsItem(
                text = rating,
                icon = R.drawable.ic_rating,
                iconDescription = stringResource(id = R.string.cont_desc_icon_rating)
            )
        }
        item {
            MovieInformationChipsItem(
                text = year,
                icon = R.drawable.ic_calendar,
                iconDescription = stringResource(id = R.string.cont_desc_icon_calendar)
            )
        }
        item {
            MovieInformationChipsItem(
                text = director,
                icon = R.drawable.ic_person,
                iconDescription = stringResource(id = R.string.cont_desc_icon_director)
            )
        }

        item { Spacer(modifier = Modifier.padding(end = 1.dp)) }
    }
}

@Preview
@Composable
fun MovieInformationChipsMenuPreview() {
    MovieInformationChipsMenu(
        category = "Action",
        rating = "8.5",
        year = "2021",
        director = "Director Name"
    )
}