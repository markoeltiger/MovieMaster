package com.mark.moviemaster.data.local.models



data class MoviesModelItem(
     val cast: List<String>,
     val genres: List<String>,
     val rating: Int,
     val title: String,
     val year: Int
)