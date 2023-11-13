package com.mark.moviemaster.data.local.repos

import android.util.Log
import com.mark.moviemaster.data.local.datasource.LocalMovieDataSource
import com.mark.moviemaster.data.local.models.MoviesModel
import com.mark.moviemaster.data.local.models.MoviesModelItem
import com.mark.moviemaster.domain.repos.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieLocalDataSource: LocalMovieDataSource,

): MovieRepository {
    override suspend fun getAllMovies(): MoviesModel {
        Log.e("movieDataSource",movieLocalDataSource.loadMovies().toString())
            return movieLocalDataSource.loadMovies()
    }
}