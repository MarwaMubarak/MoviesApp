package com.example.moviesapp.data.Models

import com.google.gson.annotations.SerializedName


data class RegisterRequest(
    @SerializedName("username") val userName: String,
    @SerializedName("password") val password: String,
    @SerializedName("email") val email: String
)
