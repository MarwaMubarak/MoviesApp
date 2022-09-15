package com.example.moviesapp.presentation.ViewModels
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActorModel(
    val image:String?,
    val name:String?,
    val id:Int?,
    val moviesList:ArrayList<MovieModel>?
    ):Parcelable