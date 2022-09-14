package com.example.moviesapp.data.Models
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActorModel(
    val image:Int,
    val name:String,
    val id:Int,
    val moviesList:String):Parcelable