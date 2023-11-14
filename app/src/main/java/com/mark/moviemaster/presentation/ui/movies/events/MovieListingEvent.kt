package com.mark.moviemaster.presentation.ui.movies.events

sealed class MovieListingEvent {
     data class OnSearchQueryChange(val query: String): MovieListingEvent()
}

