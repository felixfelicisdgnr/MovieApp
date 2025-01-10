package com.doganur.movieapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_movie")
data class FavoriteMovie(
    @PrimaryKey
    val id: Int,
    val name: String,
    val image: String,
    val category: String,
    val rating: Double,
    val year: Int,
    val director: String,
    val description: String
)
