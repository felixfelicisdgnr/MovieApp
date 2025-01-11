package com.doganur.movieapp.data.repository

import com.doganur.movieapp.common.Resource
import com.doganur.movieapp.data.model.FavoriteMovie
import com.doganur.movieapp.data.source.local.MovieDao
import com.doganur.movieapp.data.source.remote.MovieService
import com.doganur.movieapp.domain.mapper.mapToMovieCartModelList
import com.doganur.movieapp.domain.mapper.mapToMovieModelList
import com.doganur.movieapp.domain.model.MovieCartModel
import com.doganur.movieapp.domain.model.MovieModel
import com.doganur.movieapp.domain.repository.MovieRepository
import okio.EOFException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    private val movieDao: MovieDao,
) : MovieRepository {
    override suspend fun getAllMovies(): Resource<List<MovieModel>> {
        return try {
            val response = movieService.getAllMovies()
            Resource.Success(response.mapToMovieModelList())
        } catch (e: Exception) {
            Resource.Fail(e.message.orEmpty())
        }
    }

    override suspend fun addBasket(
        name: String,
        image: String,
        price: Int,
        category: String,
        rating: Double,
        year: Int,
        director: String,
        description: String,
    ): Resource<String> {
        return try {
            val response = movieService.addCartBasket(
                name = name,
                image = image,
                price = price,
                category = category,
                rating = rating,
                year = year,
                director = director,
                description = description,
            )

            if (response.success == 1) {
                Resource.Success(response.message)
            } else {
                Resource.Fail(response.message)
            }
        } catch (e: Exception) {
            Resource.Fail(e.message.orEmpty())
        }
    }

    override suspend fun getBasket(
        username: String,
    ): Resource<List<MovieCartModel>> {
        return try {
            val response = movieService.getMovieCart(
                userName = "doganur_aydeniz"
            )
            Resource.Success(response.mapToMovieCartModelList())
        } catch (e: EOFException) {
            Resource.Success(emptyList())
        } catch (e: Exception) {
            Resource.Fail(e.message.orEmpty())
        }
    }

    override suspend fun deleteMovieCart(
        cartId: Int,
    ): Resource<String> {
        return try {
            val response = movieService.deleteMovieCart(
                cartId = cartId
            )

            if (response.success == 1) {
                Resource.Success(response.message)
            } else {
                Resource.Fail(response.message)
            }
        } catch (e: Exception) {
            Resource.Fail(e.message.orEmpty())
        }
    }

    override suspend fun addFavorite(favoriteMovie: FavoriteMovie) {
        movieDao.addFavorite(favoriteMovie)
    }

    override suspend fun deleteFavorite(favoriteMovie: FavoriteMovie) {
        movieDao.deleteFavorite(favoriteMovie)
    }

    override suspend fun getFavoriteMovies(): List<FavoriteMovie> {
        return movieDao.getFavorite()
    }
}