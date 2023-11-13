package com.mark.moviemaster.utils.helper

import androidx.compose.ui.graphics.Color
import com.mark.moviemaster.data.local.models.MoviesModelItem
import kotlin.random.Random

object AppHelper  {
    var selectedMovie: MoviesModelItem? = null
    fun getMovieImageLink(farm: Int, server: String, id:String, secret:String): String {
        return "https://farm${farm}.static.flickr.com/${server}/${id}_${secret}.jpg"
    }
    fun Color.Companion.random() : Color {
        val red = Random.nextInt(256)
        val green = Random.nextInt(256)
        val blue = Random.nextInt(256)
        return Color(red, green, blue)
    }
}