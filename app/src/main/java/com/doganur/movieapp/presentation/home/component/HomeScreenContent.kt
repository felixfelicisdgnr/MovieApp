package com.doganur.movieapp.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.doganur.movieapp.common.EMPTY
import com.doganur.movieapp.domain.model.MovieModel

@Composable
fun HomeScreenContent(
    moviesItems: List<MovieModel> = emptyList(),
    onAddToBasketButtonClick: (MovieModel) -> Unit,
    imageClick: (MovieModel) -> Unit,
    onCategoryClick : (String) -> Unit,
    isCategorySelected : (String) -> Boolean,
    searchTextValue : String,
    onSearchValueChange : (String) -> Unit
) {
    val allCategories = moviesItems.map { it.category }.distinct()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        SearchTextField(
            searchTextValue = searchTextValue,
            onSearchValueChange = onSearchValueChange
        )

        CategoryChipsMenu(
            categoryList = allCategories,
            onCategoryClick = onCategoryClick,
            isSelected = { isCategorySelected(it) }
        )

        MovieList(
            moviesItems = if (isCategorySelected(String.EMPTY)) {
                moviesItems
            } else {
                moviesItems.filter { movie ->
                    isCategorySelected(movie.category)
                }
            },
            onAddToBasketButtonClick = onAddToBasketButtonClick,
            imageClick = imageClick
        )
    }
}
