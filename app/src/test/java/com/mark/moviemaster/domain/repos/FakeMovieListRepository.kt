package com.mark.moviemaster.domain.repos

import com.mark.moviemaster.data.local.models.MoviesModel
import com.mark.moviemaster.data.local.models.MoviesModelItem
import okhttp3.internal.toImmutableList

class FakeMovieListRepository: MovieRepository {

    val movies = arrayListOf(
        MoviesModelItem(emptyList(), emptyList(), 2, "Mark Saif", 2007,),
        MoviesModelItem(emptyList(), emptyList(), 2, "Orange Task", 2009,),
        MoviesModelItem(emptyList(), emptyList(), 2, "Mark Saif", 2003,),
    )

    val moviesToInsert = MoviesModel(movies)

    override suspend fun getAllMovies(): MoviesModel {
        return moviesToInsert
    }
}