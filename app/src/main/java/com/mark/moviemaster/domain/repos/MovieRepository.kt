package com.mark.moviemaster.domain.repos

import com.mark.moviemaster.data.local.models.MoviesModel

interface MovieRepository {
    suspend fun getAllMovies(): MoviesModel

}