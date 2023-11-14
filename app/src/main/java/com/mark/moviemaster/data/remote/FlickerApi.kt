package com.mark.moviemaster.data.remote

import com.mark.moviemaster.BuildConfig
import com.mark.moviemaster.data.remote.models.MovieImageResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickerApi {

    @GET("rest/")
    suspend fun getMovieImage(
        @Query("api_key") apikey: String,
        @Query("method") method: String,
        @Query("text") movieTitle: String,
        @Query("format") format: String,
        @Query("nojsoncallback") noJsonCallback: Int,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): MovieImageResponse

    companion object {
        const val METHOD = "flickr.photos.search"
        const val BASE_URL = "https://www.flickr.com/services/"
        const val API_KEY= BuildConfig.API_KEY
        const val FORMAT_JSON = "json"
        const val NO_JSON_CALLBACK = 1
        const val page = 1
        const val per_page = 20
    }
}