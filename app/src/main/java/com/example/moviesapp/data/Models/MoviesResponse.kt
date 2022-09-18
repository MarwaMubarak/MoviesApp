package com.example.moviesapp.data.Models


import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("movieId") var movieId: Int? = null,
    @SerializedName("movieName") var movieName: String? = null,
    @SerializedName("directorName") var directorName: String? = null,
    @SerializedName("movieDuration") var movieDuration: String? = null,
    @SerializedName("movieProductionYear") var movieProductionYear: String? = null,
    @SerializedName("movieCategory") var movieCategory: String? = null,
    @SerializedName("movieImageUrl") var movieImageUrl: String? = null,
    @SerializedName("movieRating") var movieRating: String? = null,
    @SerializedName("movieVideoUrl") var movieVideoUrl: String? = null,
    @SerializedName("movieDescription") var movieDescription: String? = null

)
