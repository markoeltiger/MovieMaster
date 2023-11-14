package com.mark.moviemaster.domain.usecases

import com.mark.moviemaster.data.remote.models.MovieImageResponse
import com.mark.moviemaster.domain.repos.MovieImageRepository
import com.mark.moviemaster.utils.helper.AppHelper.getMovieImageLink
import javax.inject.Inject

class GetMovieImageUseCase @Inject constructor(
    private val movieImageRepository: MovieImageRepository,
) {
    suspend fun getAllMoviesUseCase(movieTitle:String):MovieImageResponse{

      //  var imageLink = getMovieImageLink(image.farm,image.server,image.id,image.secret)
         return  movieImageRepository.getMovieImage(movieTitle)

    }
}