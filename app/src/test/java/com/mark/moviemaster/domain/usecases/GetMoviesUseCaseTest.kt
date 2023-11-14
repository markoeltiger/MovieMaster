package com.mark.moviemaster.domain.usecases

import com.google.common.truth.Truth.assertThat
import com.mark.moviemaster.domain.repos.FakeMovieListRepository
import com.mark.moviemaster.domain.repos.MovieRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class GetMoviesUseCaseTest {
    private lateinit var getMoviesUseCase: GetMoviesUseCase
    private lateinit var movieRepository: FakeMovieListRepository


    @Before
    fun setUp(){
        movieRepository = FakeMovieListRepository()
        getMoviesUseCase = GetMoviesUseCase(movieRepository)
    }

     @Test
    fun getAllMoviesUseCase() :Unit = runBlocking{
         val movies = GetMoviesUseCase(movieRepository).getAllMoviesUseCase()
         assertThat(movies.isNotEmpty()).isTrue()
     }
}