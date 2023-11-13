package com.mark.moviemaster.presentation.viewmodel.movies.ui_state

import com.mark.moviemaster.data.local.models.MoviesModelItem

data class MoviesListUiState  (
val movies: List<MoviesModelItem> = emptyList(),
val isLoading: Boolean = true,
val searchQuery: String = "",
val isError: Boolean = false,
val isSuccess: Boolean = false,)