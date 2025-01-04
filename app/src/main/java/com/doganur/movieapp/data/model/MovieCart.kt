package com.doganur.movieapp.data.model

import com.google.gson.annotations.SerializedName

data class MovieCart (

    @SerializedName("cartId")
    var cartId: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("image")
    var image: String,

    @SerializedName("price")
    var price: Int,

    @SerializedName("category")
    var category: String,

    @SerializedName("rating")
    var rating: Double,

    @SerializedName("year")
    var year: Int,

    @SerializedName("director")
    var director: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("orderAmount")
    var orderAmount: Int,

    @SerializedName("userName")
    var userName: String = "doganur_aydeniz"
)