package com.mark.moviemaster.data.remote.datasource

import com.mark.moviemaster.data.local.models.MoviesModel
import com.mark.moviemaster.data.local.models.MoviesModelItem
import com.mark.moviemaster.data.remote.models.MovieImageResponse

interface MovieImageDataSource {
    suspend fun getMovieImage(movieTitle:String):MovieImageResponse

}