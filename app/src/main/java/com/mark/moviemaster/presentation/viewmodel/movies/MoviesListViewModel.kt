package com.mark.moviemaster.presentation.viewmodel.movies

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mark.moviemaster.domain.usecases.GetMoviesUseCase
import com.mark.moviemaster.presentation.ui.movies.events.MovieListingEvent
import com.mark.moviemaster.presentation.viewmodel.movies.ui_state.MoviesListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetMoviesUseCase,
) : ViewModel() {
    private val _movieUiState = MutableStateFlow(MoviesListUiState())
    val movieUiState get() = _movieUiState.asStateFlow()
    private val _allmovieUiState = MutableStateFlow(MoviesListUiState())
    val allMovieUiState get() = _allmovieUiState.asStateFlow()
    init {
        fetchMovies()
    }
    fun onEvent(event: MovieListingEvent) {
        when (event) {
            is MovieListingEvent.OnSearchQueryChange -> {
                searchMovies(query = event.query)
            }
        }
    }
    @SuppressLint("SuspiciousIndentation")
    private fun fetchMovies() {
        viewModelScope.launch {
            try {
                val movies = getAllMoviesUseCase.getAllMoviesUseCase()

                _allmovieUiState.update {
                    it.copy(
                        movies = movies,
                        isLoading = false,
                        isError = false,
                        isSuccess = true,
                    )

                }
                    _movieUiState.update {
                     it.copy(
                        movies = movies,
                        isLoading = false,
                        isError = false,
                        isSuccess = true,
                    )

                }

            } catch (e: Exception) {
                Log.e(e.toString(),"Exception")
                _movieUiState.value = MoviesListUiState(
                    isError = true,
                    isLoading = false,
                    isSuccess = false,
                    movies = emptyList(),
                )
            }
        }
    }
    private fun searchMovies(query: String) {
         val searchMovies  =  _allmovieUiState.value.movies.filter {
                it.title.contains(query)
            }
        _movieUiState.update {
            it.copy(
                movies = searchMovies,
                isLoading = false,
                isError = false,
                isSuccess = true,
            )

    }
    }
}


