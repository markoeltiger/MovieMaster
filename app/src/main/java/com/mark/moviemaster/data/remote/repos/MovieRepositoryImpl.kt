package com.mark.moviemaster.data.remote.repos


import android.annotation.SuppressLint
import android.util.Log
import com.mark.moviemaster.data.remote.datasource.MovieImageDataSource
import com.mark.moviemaster.data.remote.models.MovieImageResponse
import com.mark.moviemaster.domain.repos.MovieImageRepository
import com.mark.moviemaster.utils.network.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieImageRepositoryImpl @Inject constructor(
    private val movieImageDataSource: MovieImageDataSource,
) : MovieImageRepository {
    @SuppressLint("SuspiciousIndentation")
    override suspend fun getMovieImage(movieTitle: String): Flow<Resource<MovieImageResponse>> {
        return flow<Resource<MovieImageResponse>> {

            var moviesListing = movieImageDataSource.getMovieImage(movieTitle)
            moviesListing.collect {
                when (it) {
                    is Resource.Success -> {
                        emit(Resource.Success(it.data))
                    }
                    else -> {
                        emit(Resource.Error("Please Make Sure You Have Stable Internet Connection"))
                    }
                }
            }
        }
    }
}