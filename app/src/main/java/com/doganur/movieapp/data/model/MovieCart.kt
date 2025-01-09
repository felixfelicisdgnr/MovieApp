package com.doganur.movieapp.data.model

import com.google.gson.annotations.SerializedName

data class MovieCart(

    @SerializedName("cartId")
    val cartId: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("image")
    val image: String? = null,

    @SerializedName("price")
    val price: Int? = null,

    @SerializedName("category")
    val category: String? = null,

    @SerializedName("rating")
    val rating: Double? = null,

    @SerializedName("year")
    val year: Int? = null,

    @SerializedName("director")
    val director: String? = null,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("orderAmount")
    val orderAmount: Int? = null,

    @SerializedName("userName")
    val username: String = "doganur_aydeniz"
)