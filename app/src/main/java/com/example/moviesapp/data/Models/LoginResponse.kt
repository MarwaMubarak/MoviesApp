package com.example.moviesapp.data.Models

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("userName") val userName:String,
    @SerializedName("password") val password:String,
    @SerializedName("email") val email:String)
