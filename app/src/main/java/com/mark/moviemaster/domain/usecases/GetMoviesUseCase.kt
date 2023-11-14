package com.mark.moviemaster.domain.usecases

import android.util.Log
import com.mark.moviemaster.data.local.models.MoviesModel
import com.mark.moviemaster.data.local.models.MoviesModelItem
import com.mark.moviemaster.domain.repos.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    suspend fun getAllMoviesUseCase(): List<MoviesModelItem> {
         return movieRepository.getAllMovies().movies
    }
}