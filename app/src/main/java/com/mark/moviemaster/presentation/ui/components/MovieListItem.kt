package com.mark.moviemaster.presentation.ui.components

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mark.moviemaster.data.local.models.MoviesModelItem
import com.mark.moviemaster.utils.helper.AppHelper.random

@Composable
fun MovieListItem (
    movie: MoviesModelItem,
    onItemClick: (MoviesModelItem) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(movie) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {


        Text(
            text = "${movie.title}",
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis,
            color =  Color.Companion.random()
        )
        Text(
            text = "${movie.year}",
            color =  Color.Companion.random(),
           style = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Ellipsis
         )

    }

}