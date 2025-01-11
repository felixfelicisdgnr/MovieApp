package com.doganur.movieapp.di

import com.doganur.movieapp.data.repository.MovieRepositoryImpl
import com.doganur.movieapp.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMainRepository(repositoryImpl: MovieRepositoryImpl): MovieRepository
}