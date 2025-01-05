package com.doganur.movieapp.ui.basket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.domain.usecase.GetBasketUseCase
import com.doganur.movieapp.ui.basket.BasketContract.UiAction
import com.doganur.movieapp.ui.basket.BasketContract.UiEffect
import com.doganur.movieapp.ui.basket.BasketContract.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(
    private val getBasketUseCase: GetBasketUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _uiEffect by lazy { Channel<UiEffect>() }
    val uiEffect: Flow<UiEffect> by lazy { _uiEffect.receiveAsFlow() }

    init {
        getBasket()
    }

    fun onAction(uiAction: UiAction) {
    }

    private fun getBasket(
        username: String = "doganur_aydeniz"
    ) = viewModelScope.launch {

        val result = getBasketUseCase(
            username = username
        )

        when (result) {
            is Resource.Success -> {
                updateUiState {
                    copy(
                        list = result.data
                    )
                }
            }

            is Resource.Fail -> {
                emitUiEffect(UiEffect.ShowToast(message = result.message))
            }
        }
    }

    private fun updateUiState(block: UiState.() -> UiState) {
        _uiState.update(block)
    }

    private suspend fun emitUiEffect(uiEffect: UiEffect) {
        _uiEffect.send(uiEffect)
    }
}