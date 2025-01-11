package com.doganur.movieapp.domain.model

data class MovieCartModel(
    val cartId: Int,
    val name: String,
    val image: String,
    val price: Int,
    val priceStr: String,
    val category: String,
    val rating: Double,
    val year: Int,
    val director: String,
    val description: String,
    val orderAmount: Int,
    val orderAmountStr: String,
    val productTotalPriceStr: String,
    val username: String = "doganur_aydeniz"
)
