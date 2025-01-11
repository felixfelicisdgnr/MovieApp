package com.doganur.movieapp.common.base.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.doganur.movieapp.presentation.theme.PrimaryColor

@Composable
fun RoundedSurface(
    modifier: Modifier = Modifier,
    borderStroke: BorderStroke = BorderStroke(0.dp, Color.Transparent),
    color: Color = PrimaryColor,
    shape: CornerBasedShape = RoundedCornerShape(10.dp),
    contentColor: Color = contentColorFor(color),
    content: Slot
) {
    Surface(
        modifier = modifier,
        color = color,
        contentColor = contentColor,
        shape = shape,
        border = borderStroke
    ) {
        content()
    }
}

@Preview
@Composable
fun RoundedSurfacePreview() {
    RoundedSurface(
        modifier = Modifier.padding(16.dp),
        color = PrimaryColor,
        content = {}
    )
}