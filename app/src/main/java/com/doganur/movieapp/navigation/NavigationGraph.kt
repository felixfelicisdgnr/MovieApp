package com.doganur.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.doganur.movieapp.presentation.basket.BasketScreen
import com.doganur.movieapp.presentation.basket.BasketViewModel
import com.doganur.movieapp.presentation.favorite.FavoriteScreen
import com.doganur.movieapp.presentation.favorite.FavoriteViewModel
import com.doganur.movieapp.presentation.home.HomeScreen
import com.doganur.movieapp.presentation.home.HomeViewModel
import com.doganur.movieapp.presentation.moviedetail.MovieDetailScreen
import com.doganur.movieapp.presentation.moviedetail.MovieDetailViewModel

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
            ) { movie ->
                navController.navigate(
                    Screen.MovieDetail(
                        movieId = movie.id,
                        name = movie.name,
                        image = movie.image,
                        price = movie.price,
                        category = movie.category,
                        rating = movie.rating,
                        year = movie.year,
                        director = movie.director,
                        description = movie.description
                    )
                )
            }


        }
        composable<Screen.MovieDetail> {
            val viewModel: MovieDetailViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect

            MovieDetailScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction,
                navigateToMovieDetail = { movieModel ->
                    navController.navigate(
                        Screen.MovieDetail(
                            movieId = movieModel.id,
                            name = movieModel.name,
                            image = movieModel.image,
                            price = movieModel.price,
                            category = movieModel.category,
                            rating = movieModel.rating,
                            year = movieModel.year,
                            director = movieModel.director,
                            description = movieModel.description
                        )
                    )
                }
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
        composable<Screen.Favorite> {
            val viewModel: FavoriteViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            FavoriteScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }

    }
}