package com.mark.moviemaster.domain.repos

import com.mark.moviemaster.data.remote.models.MovieImageResponse
import com.mark.moviemaster.utils.network.Resource
import kotlinx.coroutines.flow.Flow

interface MovieImageRepository {
    suspend fun getMovieImage(movieTitle:String): Flow<Resource<MovieImageResponse>>

}