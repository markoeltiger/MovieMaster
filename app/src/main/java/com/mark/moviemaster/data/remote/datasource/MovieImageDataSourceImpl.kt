package com.mark.moviemaster.data.remote.datasource


import android.annotation.SuppressLint
import android.util.Log
import com.mark.moviemaster.data.remote.FlickerApi
import com.mark.moviemaster.data.remote.models.MovieImageResponse
import kotlinx.coroutines.flow.Flow
import com.mark.moviemaster.utils.network.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieImageDataSourceImpl @Inject constructor(
    private val api: FlickerApi,

    ): MovieImageDataSource {

    @SuppressLint("SuspiciousIndentation")
    override suspend fun getMovieImage(movieTitle:String): Flow<Resource<MovieImageResponse>> {
        return flow<Resource<MovieImageResponse>> {
            try {
                var moviesListing= api.getMovieImage(FlickerApi.API_KEY,FlickerApi.METHOD,movieTitle,FlickerApi.FORMAT_JSON,FlickerApi.NO_JSON_CALLBACK,FlickerApi.page,FlickerApi.per_page)
                    emit(Resource.Success(moviesListing))
            } catch(e: IOException) {
                 e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Please Make Sure You Have Stable Internet Connection"))
                null
            }


        }

     }
}
