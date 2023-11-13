package com.mark.moviemaster.presentation.viewmodel.movieimage

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mark.moviemaster.domain.usecases.GetMovieImageUseCase
import com.mark.moviemaster.domain.usecases.GetMoviesUseCase
import com.mark.moviemaster.presentation.viewmodel.movies.ui_state.MoviesListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieImageUseCase: GetMovieImageUseCase,
) : ViewModel() {
    private val viewModelScope = CoroutineScope(Dispatchers.Main)
     val movieDetail = MutableStateFlow(MoviesListUiState())
    fun movieDetail(movieTitle:String) {
        viewModelScope.launch(Dispatchers.Main) {
         Log.e("imageLink",getMovieImageUseCase.getAllMoviesUseCase(movieTitle))
        }
    }
}