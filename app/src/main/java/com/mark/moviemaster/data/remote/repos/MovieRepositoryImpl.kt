package com.mark.moviemaster.data.remote.repos


import com.mark.moviemaster.data.remote.datasource.MovieImageDataSource
import com.mark.moviemaster.data.remote.models.MovieImageResponse
import com.mark.moviemaster.domain.repos.MovieImageRepository
import javax.inject.Inject

class MovieImageRepositoryImpl @Inject constructor(
    private val movieImageDataSource: MovieImageDataSource,
): MovieImageRepository {
    override suspend fun getMovieImage(movieTitle: String): MovieImageResponse {
         return movieImageDataSource.getMovieImage(movieTitle)
    }

}