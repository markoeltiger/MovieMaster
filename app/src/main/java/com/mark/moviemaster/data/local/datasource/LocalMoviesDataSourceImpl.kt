package com.mark.moviemaster.data.local.datasource

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mark.moviemaster.data.local.models.MoviesModel
import com.mark.moviemaster.data.local.models.MoviesModelItem
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalMoviesDataSourceImpl @Inject constructor( @ApplicationContext private val context: Context): LocalMovieDataSource {
    //Reading Movies From Local JSon file in assets folder
    override suspend fun loadMovies(): MoviesModel= withContext(Dispatchers.IO) {
        val jsonString = context.assets.open("movies.json").bufferedReader().use {
            it.readText()
        }
        val gson = Gson()
        val movieListType = object : TypeToken<MoviesModel>() {}.type
        gson.fromJson(jsonString, movieListType)
    }
    }
