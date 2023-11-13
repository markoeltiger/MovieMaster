package com.mark.moviemaster.presentation.ui.movies



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mark.moviemaster.R
import com.mark.moviemaster.presentation.ui.components.MovieListItem
import com.mark.moviemaster.presentation.ui.navigation.Routes
import com.mark.moviemaster.presentation.viewmodel.movies.MoviesListViewModel
import com.mark.moviemaster.utils.helper.AppHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(
    navController: NavController,
    viewModel: MoviesListViewModel = hiltViewModel()
    ){
    val movieUiState by viewModel.movieUiState.collectAsState()
Column {

    OutlinedTextField(
        value = viewModel.movieUiState.value.searchQuery,
        onValueChange = {
//            viewModel.onEvent(
//                CompanyListingsEvent.OnSearchQueryChange(it)
//            )
        },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
        ,
        placeholder = {
            Text(text = "Search...",)
            colorResource(id = R.color.white)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(

            focusedLabelColor = colorResource(id = R.color.white),
            cursorColor = colorResource(id = R.color.teal_700)
        ),
        maxLines = 1,
        singleLine = true
    )
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(movieUiState!!.movies.size) { movie ->
                MovieListItem(
                    movie = movieUiState!!.movies.get(movie),
                    onItemClick = {
                        AppHelper.selectedMovie=it
                        navController.navigate(Routes.MovieDetailScreen.route)
                    }
                )
            }
        }
    }

}
}


