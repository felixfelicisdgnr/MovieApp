package com.doganur.movieapp.presentation.basket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.domain.usecase.AddBasketUseCase
import com.doganur.movieapp.domain.usecase.DeleteMovieCartUseCase
import com.doganur.movieapp.domain.usecase.GetGroupedBasketUseCase
import com.doganur.movieapp.presentation.basket.BasketContract.UiAction
import com.doganur.movieapp.presentation.basket.BasketContract.UiEffect
import com.doganur.movieapp.presentation.basket.BasketContract.UiState
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
    private val deleteMovieCartUseCase: DeleteMovieCartUseCase,
    private val addBasketUseCase: AddBasketUseCase,
    private val getGroupedBasketUseCase: GetGroupedBasketUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _uiEffect by lazy { Channel<UiEffect>() }
    val uiEffect: Flow<UiEffect> by lazy { _uiEffect.receiveAsFlow() }

    init {
        getBasket()
    }

    fun onAction(uiAction: UiAction) {
        when (uiAction) {
            is UiAction.OnIncreaseButtonClick -> increaseMovieAmount(uiAction.movieCartModel.cartId)
            is UiAction.OnDecreaseButtonClick -> decreaseMovieAmount(uiAction.movieCartModel.cartId)
        }
    }

    private fun getBasket(
        username: String = "doganur_aydeniz"
    ) = viewModelScope.launch {

        updateUiState { copy(isLoading = true) }

        when (val result = getGroupedBasketUseCase(username)) {
            is Resource.Success -> {
                updateUiState {
                    copy(
                        list = result.data.sortedBy { it.cartId },
                        isLoading = false
                    )
                }
            }

            is Resource.Fail -> {
                emitUiEffect(UiEffect.ShowToast(message = result.message))
                updateUiState { copy(isLoading = false) }
            }
        }
    }

    private fun deleteMovieCart(
        cartId: Int
    ) = viewModelScope.launch {
        val result = deleteMovieCartUseCase(
            cartId = cartId,
        )
        when (result) {
            is Resource.Success -> {
                getBasket() // Sepeti yenile
            }

            is Resource.Fail -> {
            }
        }
    }

    private fun increaseMovieAmount(
        cartId: Int
    ) = viewModelScope.launch {

        val currentMovie = _uiState.value.list.find { it.cartId == cartId } // Mevcut filmi ekle

        currentMovie?.let {
            val result = addBasketUseCase(
                name = it.name,
                price = it.price,
                image = it.image,
                category = it.category,
                rating = it.rating,
                year = it.year,
                director = it.director,
                description = it.description,
            )

            when (result) {
                is Resource.Success -> {
                    getBasket() // Sepeti yenile
                }

                is Resource.Fail -> {
                    emitUiEffect(UiEffect.ShowToast(message = result.message))
                }
            }
        }
    }

    private fun decreaseMovieAmount(
        cartId: Int
    ) = viewModelScope.launch {

        deleteMovieCart(cartId)
    }

    private fun updateUiState(block: UiState.() -> UiState) {
        _uiState.update(block)
    }

    private suspend fun emitUiEffect(uiEffect: UiEffect) {
        _uiEffect.send(uiEffect)
    }
}