package com.example.moviesapp.data.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieModel (val image: Int,
                       val name: String,
                       val time: String,
                       val category: String,
                       val director: String,
                       val year: String,
                       val description: String,
                       val trailer: String,
                       val rating: Double) : Parcelable
