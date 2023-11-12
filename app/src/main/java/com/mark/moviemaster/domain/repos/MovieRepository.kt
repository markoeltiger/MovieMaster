package com.mark.moviemaster.domain.repos

import com.mark.moviemaster.data.local.models.MoviesModelItem

interface MovieRepository {
    suspend fun getAllMovies(): List<MoviesModelItem>

}