package com.example.moviesapp.presentation.ViewModels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieModel (val image: String?,
                       val name: String?,
                       val time: String?,
                       val category: String?,
                       val director: String?,
                       val year: String?,
                       val description: String?,
                       val trailer: String?,
                       val rating: String?
                       ) : Parcelable
