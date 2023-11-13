package com.mark.moviemaster.presentation.ui.moviedetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mark.moviemaster.presentation.ui.components.MovieListItem
import com.mark.moviemaster.presentation.ui.navigation.Routes
import com.mark.moviemaster.presentation.viewmodel.movieimage.MovieDetailsViewModel
import com.mark.moviemaster.utils.helper.AppHelper
import com.mark.moviemaster.utils.helper.AppHelper.random
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MovieDetailsScreen(
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val movieUiState by viewModel.movieDetail.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.White
            )
    ) {
        UiDetail()
        viewModel.movieDetail(AppHelper.selectedMovie!!.title)
        viewModel.movieDetail.collectAsState().value?.let {
            when (it) {

            }
        }
    }
}

@Composable
fun UiDetail() {
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
                    text = "Movie Name :  ",
                    modifier = Modifier.padding(top = 10.dp),
                    color = Color.Black,
                    fontSize = 17.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${selectedMovie!!.title} (${selectedMovie.year})",
                    modifier = Modifier.padding(top = 10.dp),
                    color = Color.Black,
                    fontSize = 17.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
if (selectedMovie!!.cast.size>1){
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
                    items(selectedMovie!!.cast.size) { item ->
                        Text(
                            text = "${selectedMovie?.cast?.get(item)}",
                            modifier = Modifier.align(CenterVertically),
                            color = Color.Companion.random(),
                            fontSize = 17.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                    }

                }
            }
}
            if (selectedMovie!!.genres.size>1) {

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
                        items(selectedMovie!!.cast.size) { item ->
                            Text(
                                text = "${selectedMovie!!.genres.get(item)}",
                                modifier = Modifier.align(CenterVertically),
                                color = Color.Companion.random(),
                                fontSize = 17.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Spacer(modifier = Modifier.width(2.dp))

                        }

                    }
                }
            }
        }

    }
}


