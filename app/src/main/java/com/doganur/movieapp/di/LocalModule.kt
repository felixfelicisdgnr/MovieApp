package com.doganur.movieapp.di

import android.content.Context
import androidx.room.Room
import com.doganur.movieapp.data.source.local.MovieDao
import com.doganur.movieapp.data.source.local.MovieRoomDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): MovieRoomDB {
        return Room.databaseBuilder(
            context,
            MovieRoomDB::class.java,
            MovieRoomDB::class.simpleName
        ).build()
    }

    @Provides
    fun provideMainDao(database: MovieRoomDB): MovieDao = database.mainDao()
}