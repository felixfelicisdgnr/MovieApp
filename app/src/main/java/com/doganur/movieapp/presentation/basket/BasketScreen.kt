package com.doganur.movieapp.presentation.basket

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.doganur.movieapp.presentation.basket.BasketContract.UiAction
import com.doganur.movieapp.presentation.basket.BasketContract.UiEffect
import com.doganur.movieapp.presentation.basket.BasketContract.UiState
import com.doganur.movieapp.presentation.basket.component.BasketScreenContent
import com.doganur.movieapp.presentation.basket.preview.BasketScreenPreviewProvider
import com.doganur.movieapp.presentation.components.EmptyScreen
import com.doganur.movieapp.presentation.components.LoadingBar
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun BasketScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isEmpty() -> EmptyScreen()
        else -> BasketScreenContent(
            basketList = uiState.list,
            onDeleteButtonClick = { onAction(UiAction.OnDeleteButtonClick(it)) },
            onIncreaseButtonClick = { onAction(UiAction.OnIncreaseButtonClick(it)) },
            onDecreaseButtonClick = { onAction(UiAction.OnDecreaseButtonClick(it)) },
        )
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