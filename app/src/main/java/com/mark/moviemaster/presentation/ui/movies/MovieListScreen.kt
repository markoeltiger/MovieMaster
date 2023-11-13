package com.mark.moviemaster.presentation.ui.movies

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mark.moviemaster.presentation.ui.components.MovieListItem
import com.mark.moviemaster.presentation.ui.navigation.Routes
import com.mark.moviemaster.presentation.viewmodel.movies.MoviesListViewModel
import com.mark.moviemaster.presentation.viewmodel.movies.ui_state.MoviesListUiState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@Composable
fun MovieListScreen(
    navController: NavController,
    viewModel: MoviesListViewModel = hiltViewModel()
    ){
    val movieUiState by viewModel.movieUiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(movieUiState!!.movies.size) { movie ->
                MovieListItem(
                    movie = movieUiState!!.movies.get(movie),
                    onItemClick = {
                        navController.navigate(Routes.MovieDetailScreen.route)
                    }
                )
            }
        }
    }
}