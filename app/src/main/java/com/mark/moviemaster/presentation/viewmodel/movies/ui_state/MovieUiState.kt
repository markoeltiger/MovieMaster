package com.mark.moviemaster.presentation.viewmodel.movies.ui_state

data class MovieUiState(val title: String = "",
                         val rating: Int = 0,
                        val year :Int = 0 ,
                        val genres: List<String> = emptyList(),
                        val cast: List<String> = emptyList()
                        )
