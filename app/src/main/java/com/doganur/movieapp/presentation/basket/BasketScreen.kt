package com.doganur.movieapp.presentation.basket

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.doganur.movieapp.presentation.basket.BasketContract.UiAction
import com.doganur.movieapp.presentation.basket.BasketContract.UiEffect
import com.doganur.movieapp.presentation.basket.BasketContract.UiState
import com.doganur.movieapp.presentation.basket.component.BasketScreenContent
import com.doganur.movieapp.presentation.basket.preview.BasketScreenPreviewProvider
import com.doganur.movieapp.presentation.components.EmptyScreen
import com.doganur.movieapp.presentation.components.LoadingBar
import com.doganur.movieapp.presentation.home.HomeContract
import com.doganur.movieapp.presentation.home.component.HomeScreenContent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun BasketScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        if (uiState.list.isEmpty() && !uiState.isLoading) {
            EmptyScreen()
        } else {
            BasketScreenContent(
                basketList = uiState.list,
                onDeleteButtonClick = { onAction(UiAction.OnDeleteButtonClick(it)) },
                onIncreaseButtonClick = { onAction(UiAction.OnIncreaseButtonClick(it)) },
                onDecreaseButtonClick = { onAction(UiAction.OnDecreaseButtonClick(it)) },
            )
        }

        if (uiState.isLoading) LoadingBar()
    }
}

@Preview(showBackground = true)
@Composable
fun BasketScreenPreview(
    @PreviewParameter(BasketScreenPreviewProvider::class) uiState: UiState,
) {
    BasketScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
    )
}