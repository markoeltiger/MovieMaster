package com.mark.moviemaster.data.local.datasource

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mark.moviemaster.data.local.models.MoviesModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalMoviesDataSourceImpl(private val context: Context): LocalMovieDataSource {
    override suspend fun loadMovies(): List<MoviesModelItem> = withContext(Dispatchers.IO) {
        val jsonString = context.assets.open("movies.json").bufferedReader().use {
            it.readText()
        }
        val gson = Gson()
        val movieListType = object : TypeToken<List<MoviesModelItem>>() {}.type
        gson.fromJson(jsonString, movieListType)
    }
    }
