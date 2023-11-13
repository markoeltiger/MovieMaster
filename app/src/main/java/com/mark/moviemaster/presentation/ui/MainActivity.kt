package com.mark.moviemaster.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.mark.moviemaster.presentation.ui.moviedetails.MovieDetailsScreen
import com.mark.moviemaster.presentation.ui.movies.MovieListScreen
import com.mark.moviemaster.presentation.ui.navigation.Routes
import com.mark.moviemaster.presentation.ui.theme.MovieMasterTheme
import com.mark.moviemaster.presentation.viewmodel.movies.MoviesListViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
 class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieMasterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,

                    ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Routes.MoviesListScreen.route
                    ) {
                        composable(
                            route = Routes.MoviesListScreen.route
                        ) {
                            MovieListScreen(navController)
                        }
                        composable(
                            route = Routes.MovieDetailScreen.route
                        ) {
                            MovieDetailsScreen(navController)

                        }


                    }
                }
            }
        }
    }

}