package com.mark.moviemaster.di

import com.mark.moviemaster.data.local.datasource.LocalMovieDataSource
import com.mark.moviemaster.data.local.datasource.LocalMoviesDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindLocalDataSource(
        localDataSource: LocalMoviesDataSourceImpl,
    ): LocalMovieDataSource
}