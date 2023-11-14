package com.mark.moviemaster.data.remote.datasource

import com.mark.moviemaster.data.local.models.MoviesModel
import com.mark.moviemaster.data.local.models.MoviesModelItem
import com.mark.moviemaster.data.remote.models.MovieImageResponse
import com.mark.moviemaster.utils.network.Resource
import kotlinx.coroutines.flow.Flow

interface MovieImageDataSource {
    suspend fun getMovieImage(movieTitle:String): Flow<Resource<MovieImageResponse>>

}