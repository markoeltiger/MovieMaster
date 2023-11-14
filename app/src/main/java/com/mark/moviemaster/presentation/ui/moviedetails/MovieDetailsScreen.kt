package com.mark.moviemaster.presentation.ui.moviedetails

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mark.moviemaster.R
import com.mark.moviemaster.presentation.viewmodel.movieimage.MovieDetailsViewModel
import com.mark.moviemaster.presentation.viewmodel.movieimage.ui_state.MovieUiState
import com.mark.moviemaster.utils.helper.AppHelper
import com.mark.moviemaster.utils.helper.AppHelper.getMovieImageLink
import com.mark.moviemaster.utils.helper.AppHelper.random
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@Composable
fun MovieDetailsScreen(
    navController: NavController, viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    var state: MovieUiState by remember { mutableStateOf(MovieUiState()) }
    //Launched Effect to stop calling the function when recomposation
    LaunchedEffect(true) {
        viewModel.movieDetail(AppHelper.selectedMovie!!.title)

        launch {
            state = viewModel.movieDetail.value
        }
        viewModel.movieDetail.collectLatest {
            state = it
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.White
            )
    ) {
        Column {
            MovieDetail()
            state.photos.let {
                Row {
                    LazyColumn {
                        items(it.size / 2) { item ->
                            var image = state.photos.get(item + 10)
                            GlideImage(
                                imageModel = getMovieImageLink(
                                    image.farm,
                                    image.server,
                                    image.id,
                                    image.secret
                                ),
                                contentScale = ContentScale.Crop,
                                circularReveal = CircularReveal(duration = 100),
                                alignment = Alignment.Center,

                                shimmerParams = ShimmerParams(
                                    baseColor = Color.LightGray,
                                    highlightColor = Color.Gray,
                                    durationMillis = 500,
                                    dropOff = 0.55f,
                                    tilt = 20f

                                ),
                                modifier = Modifier
                                    .width(200.dp)
                                    .height(100.dp)
                                    .padding(4.dp)
                            )

                        }
                    }
                    LazyColumn {

                        items(it.size / 2) { item ->
                            var image = state.photos.get(item)
                            GlideImage(

                                imageModel = getMovieImageLink(
                                    image.farm,
                                    image.server,
                                    image.id,
                                    image.secret
                                ),

                                circularReveal = CircularReveal(duration = 100),
                                alignment = Alignment.Center,

                                shimmerParams = ShimmerParams(
                                    baseColor = Color.LightGray,
                                    highlightColor = Color.Gray,
                                    durationMillis = 500,
                                    dropOff = 0.55f,
                                    tilt = 20f

                                ),
                                modifier = Modifier
                                    .width(200.dp)
                                    .height(100.dp)
                                    .padding(4.dp)
                            )

                        }
                    }
                }
            }
        }

    }
}
@Composable
fun MovieDetail(
) {
    var selectedMovie = AppHelper.selectedMovie
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, top = 10.dp)
            ) {

                Text(
                    text = "${selectedMovie!!.title} (${selectedMovie.year})",
                    modifier = Modifier.padding(top = 10.dp),
                    color = Color.Black,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            if (selectedMovie!!.cast.size > 1) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp, top = 10.dp)
                ) {
                    Text(
                        text = "Cast : ",
                        color = Color.Black,
                        fontSize = 17.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    LazyRow(
                        modifier = Modifier.align(CenterVertically),
                    ) {
                        items(selectedMovie.cast.size) { item ->
                            Text(
                                text = "${selectedMovie.cast?.get(item)}",
                                modifier = Modifier.align(CenterVertically),
                                color = Color.Companion.random(),
                                fontSize = 17.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                        }
                    }
                }
            }
            if (selectedMovie.genres.size > 1) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp, top = 10.dp)
                ) {
                    Text(
                        text = "Genres : ",
                        color = Color.Black,
                        fontSize = 17.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    LazyRow(
                        modifier = Modifier.align(CenterVertically),
                    ) {
                        items(selectedMovie.genres.size) { item ->
                            Text(
                                text = "${selectedMovie.genres.get(item)}",
                                modifier = Modifier.align(CenterVertically),
                                color = Color.Companion.random(),
                                fontSize = 17.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                        }
                    }
                }
            }
            Text(
                text = "Movie Images",
                color = Color.Black,
                modifier = Modifier.align(CenterHorizontally),
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


