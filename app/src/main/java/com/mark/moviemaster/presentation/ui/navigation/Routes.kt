package com.mark.moviemaster.presentation.ui.navigation

sealed class Routes(val route: String) {
    object MoviesListScreen: Routes("movie_list_screen")
    object MovieDetailScreen: Routes("movie_detail_screen")
}
