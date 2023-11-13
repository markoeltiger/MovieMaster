package com.mark.moviemaster.data.remote.datasource

import android.content.Context
import android.util.Log
import com.bumptech.glide.load.engine.Resource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mark.moviemaster.data.local.models.MoviesModel
import com.mark.moviemaster.data.local.models.MoviesModelItem
import com.mark.moviemaster.data.remote.FlickerApi
import com.mark.moviemaster.data.remote.models.MovieImageResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieImageDataSourceImpl @Inject constructor(
    private val api: FlickerApi,

    ): MovieImageDataSource {

    override suspend fun getMovieImage(movieTitle:String): MovieImageResponse {

         return api.getMovieImage(FlickerApi.API_KEY,FlickerApi.METHOD,movieTitle,FlickerApi.FORMAT_JSON,FlickerApi.NO_JSON_CALLBACK,FlickerApi.page,FlickerApi.per_page)
    }
}
