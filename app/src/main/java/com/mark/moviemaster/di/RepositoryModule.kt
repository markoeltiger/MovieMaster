package com.mark.moviemaster.di


import com.mark.moviemaster.data.local.repos.MovieRepositoryImpl
import com.mark.moviemaster.domain.repos.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindMoviesRepository(
        moviesRepositoryImpl: MovieRepositoryImpl,
    ): MovieRepository
}