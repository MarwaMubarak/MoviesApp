package com.example.moviesapp.data.Network

import com.example.moviesapp.data.Models.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
//https://our-movie-service.herokuapp.com/Movies/getmovies
//https://our-movie-service.herokuapp.com/Users/login
//https://our-movie-service.herokuapp.com/Users/register
//https://our-movie-service.herokuapp.com/Actors/getactors

interface Apis {

    @POST("Users/login")
     fun login(@Body loginRequest: LoginRequest):Call<LoginResponse>
    @POST("Users/register")
    fun register(@Body registerRequest: RegisterRequest):Call<ResponseBody>

    @GET("Movies/getmovies")
     fun getAllMovies(): Call<ArrayList<MoviesResponse>>

    @GET("Actors/getactors")
    fun getAllActors(): Call<ArrayList<ActorsResponse>>
}
var retrofit = Retrofit.Builder()
    .baseUrl("https://our-movie-service.herokuapp.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
var service :Apis = retrofit.create(Apis::class.java)