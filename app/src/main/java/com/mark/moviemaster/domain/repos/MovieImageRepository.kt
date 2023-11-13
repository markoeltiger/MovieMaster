package com.mark.moviemaster.domain.repos

import com.mark.moviemaster.data.remote.models.MovieImageResponse

interface MovieImageRepository {
    suspend fun getMovieImage(movieTitle:String): MovieImageResponse

}