package com.doganur.movieapp.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.doganur.movieapp.common.collectWithLifecycle
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.ui.components.EmptyScreen
import com.doganur.movieapp.ui.components.LoadingBar
import com.doganur.movieapp.ui.home.HomeContract.UiAction
import com.doganur.movieapp.ui.home.HomeContract.UiEffect
import com.doganur.movieapp.ui.home.HomeContract.UiState
import com.doganur.movieapp.ui.home.component.MovieItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun HomeScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    val context = LocalContext.current
    uiEffect.collectWithLifecycle {
        when (it) {
            is UiEffect.ShowToast -> Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
        }
    }

    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isEmpty() -> EmptyScreen()
        else -> HomeContent(
            moviesItems = uiState.list,
            onAddToBasketButtonClick = { onAction(UiAction.OnAddToBasketClick(it)) }
        )
    }
}

@Composable
fun HomeContent(
    moviesItems: List<MovieModel> = emptyList(),
    onAddToBasketButtonClick: (MovieModel) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        MoviesList(
            moviesItems = moviesItems,
            onAddToBasketButtonClick = onAddToBasketButtonClick
        )
    }
}

@Composable
fun MoviesList(
    moviesItems: List<MovieModel>,
    onAddToBasketButtonClick: (MovieModel) -> Unit,
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(count = 2),
        horizontalArrangement = Arrangement.spacedBy(space = 12.dp),
        verticalArrangement = Arrangement.spacedBy(space = 9.dp)
    ) {
        items(moviesItems) { movie ->
            MovieItem(
                imageUrl = movie.image,
                movieTitle = movie.name,
                moviePrice = movie.priceStr,
                addBasketButtonClick = { onAddToBasketButtonClick(movie) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieItemPreview(
    @PreviewParameter(HomeScreenPreviewProvider::class) uiState: UiState,
) {
    HomeScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {}
    )
}