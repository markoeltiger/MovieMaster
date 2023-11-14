package com.mark.moviemaster.presentation.viewmodel.movieimage.ui_state

import com.mark.moviemaster.data.remote.models.Photo

data class MovieUiState(
                        val photos: List<Photo> = emptyList(),
    )
