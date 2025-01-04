package com.doganur.movieapp.di

import com.doganur.movieapp.data.repository.MainRepositoryImpl
import com.doganur.movieapp.domain.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMainRepository(repositoryImpl: MainRepositoryImpl): MainRepository
}