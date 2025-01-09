package com.doganur.movieapp.presentation.home.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CategoryChipsMenu(
    categoryList: List<String> = emptyList(),
    onCategoryClick: (String) -> Unit
) {

}


@Composable
@Preview
fun CategoryChipsMenuPreview() {
    CategoryChipsMenu(
        categoryList = listOf("Action", "Comedy", "Drama", "Horror", "Sci-Fi"),
        onCategoryClick = {}
    )
}