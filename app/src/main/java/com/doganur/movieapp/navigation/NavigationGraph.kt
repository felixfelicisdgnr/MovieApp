package com.doganur.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.doganur.movieapp.ui.home.HomeScreen
import com.doganur.movieapp.ui.home.HomeViewModel
import com.doganur.movieapp.ui.moviedetail.MovieDetailScreen
import com.doganur.movieapp.ui.moviedetail.MovieDetailViewModel
import com.doganur.movieapp.ui.basket.BasketScreen
import com.doganur.movieapp.ui.basket.BasketViewModel
import com.doganur.movieapp.ui.favourites.FavouritesScreen
import com.doganur.movieapp.ui.favourites.FavouritesViewModel

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: Screen,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable<Screen.Home> {
            val viewModel: HomeViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            HomeScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Screen.MovieDetail> {
            val viewModel: MovieDetailViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            MovieDetailScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Screen.Basket> {
            val viewModel: BasketViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            BasketScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
        composable<Screen.Favourites> {
            val viewModel: FavouritesViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            FavouritesScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }

    }
}