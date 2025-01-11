package com.doganur.movieapp.presentation.home

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.doganur.movieapp.common.base.components.LoadingBar
import com.doganur.movieapp.common.collectWithLifecycle
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.presentation.home.HomeContract.UiAction
import com.doganur.movieapp.presentation.home.HomeContract.UiEffect
import com.doganur.movieapp.presentation.home.HomeContract.UiState
import com.doganur.movieapp.presentation.home.component.HomeScreenContent
import com.doganur.movieapp.presentation.home.preview.HomeScreenPreviewProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun HomeScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
    navigateToMovieDetail: (MovieModel) -> Unit
) {
    val context = LocalContext.current
    uiEffect.collectWithLifecycle {
        when (it) {
            is UiEffect.ShowToast -> Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
            is UiEffect.NavigateToMovieDetail -> navigateToMovieDetail(it.movieModel)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(8.dp))
            .padding(vertical = 10.dp),
        contentAlignment = Alignment.Center,
    ) {
        HomeScreenContent(
            isLoading = uiState.isLoading,
            moviesItems = uiState.movies,
            onAddToBasketButtonClick = { onAction(UiAction.OnAddToBasketClick(it)) },
            imageClick = { navigateToMovieDetail(it) },
            categories = uiState.categories,
            onCategoryClick = { onAction(UiAction.OnCategoryClick(it)) },
            selectedCategory = uiState.selectedCategory,
            searchTextValue = uiState.searchText,
            onSearchValueChange = { onAction(UiAction.OnSearchValueChange(it)) },
            selectedSortType = uiState.selectedSortType,
            onSortTypeSelect = { onAction(UiAction.OnSortTypeChange(it)) }
        )

        if (uiState.isLoading) LoadingBar()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(
    @PreviewParameter(HomeScreenPreviewProvider::class) uiState: UiState,
) {
    HomeScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
        navigateToMovieDetail = {}
    )
}