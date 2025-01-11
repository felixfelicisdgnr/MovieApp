package com.doganur.movieapp.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.doganur.movieapp.common.base.components.EmptyScreen
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.domain.model.SortType

@Composable
fun HomeScreenContent(
    moviesItems: List<MovieModel> = emptyList(),
    onAddToBasketButtonClick: (MovieModel) -> Unit,
    imageClick: (MovieModel) -> Unit,
    categories: List<String>,
    onCategoryClick: (String) -> Unit,
    selectedCategory: String,
    searchTextValue: String,
    onSearchValueChange: (String) -> Unit,
    selectedSortType: SortType,
    onSortTypeSelect: (SortType) -> Unit,
    isLoading: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        SearchTextField(
            searchTextValue = searchTextValue,
            onSearchValueChange = onSearchValueChange,
            selectedSortType = selectedSortType,
            onSortTypeSelect = onSortTypeSelect
        )

        CategoryChipsMenu(
            categoryList = categories,
            selectedCategory = selectedCategory,
            onCategoryClick = onCategoryClick
        )

        if (moviesItems.isEmpty() && !isLoading) {
            EmptyScreen()
        } else {
            MovieList(
                moviesItems = moviesItems,
                onAddToBasketButtonClick = onAddToBasketButtonClick,
                imageClick = imageClick
            )

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
