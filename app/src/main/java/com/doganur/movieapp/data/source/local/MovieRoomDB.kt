package com.doganur.movieapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.doganur.movieapp.data.model.FavoriteMovie

@Database(entities = [FavoriteMovie::class], version = 1, exportSchema = false)
abstract class MovieRoomDB : RoomDatabase() {
    abstract fun mainDao(): MovieDao
}