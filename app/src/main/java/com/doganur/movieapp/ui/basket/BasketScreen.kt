package com.doganur.movieapp.ui.basket

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import com.doganur.movieapp.ui.components.EmptyScreen
import com.doganur.movieapp.ui.components.LoadingBar
import com.doganur.movieapp.ui.basket.BasketContract.UiAction
import com.doganur.movieapp.ui.basket.BasketContract.UiEffect
import com.doganur.movieapp.ui.basket.BasketContract.UiState
import com.doganur.movieapp.ui.basket.component.BasketScreenContent
import com.doganur.movieapp.ui.basket.preview.BasketScreenPreviewProvider
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