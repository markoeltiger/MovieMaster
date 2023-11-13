package com.mark.moviemaster.domain.usecases

import com.mark.moviemaster.domain.repos.MovieImageRepository
import com.mark.moviemaster.utils.helper.AppHelper.getMovieImageLink
import javax.inject.Inject

class GetMovieImageUseCase @Inject constructor(
    private val movieImageRepository: MovieImageRepository,
) {
    suspend fun getAllMoviesUseCase(movieTitle:String):String{
        var image = movieImageRepository.getMovieImage(movieTitle).photos.photo.first()
        var imageLink = getMovieImageLink(image.farm,image.server,image.id,image.secret)
         return imageLink

    }
}