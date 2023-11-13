package com.mark.moviemaster.data.remote.models


import com.google.gson.annotations.SerializedName

data class MovieImageResponse(
    @SerializedName("photos")
    val photos: Photos,
    @SerializedName("stat")
    val stat: String
)