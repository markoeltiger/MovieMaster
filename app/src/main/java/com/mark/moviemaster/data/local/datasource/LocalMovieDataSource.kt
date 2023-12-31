package com.mark.moviemaster.data.local.datasource

import com.mark.moviemaster.data.local.models.MoviesModel
import com.mark.moviemaster.data.local.models.MoviesModelItem

interface LocalMovieDataSource {
    suspend fun loadMovies(): MoviesModel

}