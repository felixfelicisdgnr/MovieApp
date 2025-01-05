package com.doganur.movieapp.data.model

import com.google.gson.annotations.SerializedName

data class MovieCart(

    @SerializedName("cartId")
    var cartId: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("price")
    var price: Int? = null,

    @SerializedName("category")
    var category: String? = null,

    @SerializedName("rating")
    var rating: Double? = null,

    @SerializedName("year")
    var year: Int? = null,

    @SerializedName("director")
    var director: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("orderAmount")
    var orderAmount: Int? = null,

    @SerializedName("userName")
    var userName: String = "doganur_aydeniz"
)