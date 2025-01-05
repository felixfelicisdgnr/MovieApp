package com.doganur.movieapp.data.source.remote

import com.doganur.movieapp.data.model.BaseResponse
import com.doganur.movieapp.data.model.GetAllMoviesResponse
import com.doganur.movieapp.data.model.MovieCartResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MainService {
    @GET("movies/getAllMovies.php")
    suspend fun getAllMovies(): GetAllMoviesResponse

    @POST("movies/insertMovie.php")
    @FormUrlEncoded
    suspend fun addCartBasket(
        @Field("name") name: String,
        @Field("image") image: String,
        @Field("price") price: Int,
        @Field("category") category: String,
        @Field("rating") rating: Double,
        @Field("year") year: Int,
        @Field("director") director: String,
        @Field("description") description: String,
        @Field("orderAmount") orderAmount: Int = 1,
        @Field("userName") userName: String = "doganur_aydeniz", // bunu bir düşün const val olarak tanımlamak mantıklı mı
    ): BaseResponse

    @POST("movies/getMovieCart.php")
    @FormUrlEncoded
    suspend fun getMovieCart(
        @Field("userName") userName: String
    ): MovieCartResponse

    @POST("movies/deleteMovie.php")
    @FormUrlEncoded
    suspend fun deleteMovieCart(
        @Field("cartId") cartId: Int,
        @Field("userName") userName: String = "doganur_aydeniz"
    ): BaseResponse
}