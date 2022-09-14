package com.example.moviesapp.data.Models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegisterResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("userName") val userName:String,
    @SerializedName("password") val password:String,
    @SerializedName("email") val email:String):Parcelable