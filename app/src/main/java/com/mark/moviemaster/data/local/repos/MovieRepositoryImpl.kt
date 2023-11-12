package com.mark.moviemaster.data.local.repos

import com.mark.moviemaster.data.local.datasource.LocalMovieDataSource
import com.mark.moviemaster.data.local.models.MoviesModelItem
import com.mark.moviemaster.domain.repos.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieLocalDataSource: LocalMovieDataSource,

): MovieRepository {
    override suspend fun getAllMovies(): List<MoviesModelItem> {
            return movieLocalDataSource.loadMovies()
    }
}