package com.example.moviesapp.data.Network

//import com.example.moviesapp.data.Models.RegisterResponse
import com.example.moviesapp.data.Models.LoginRequest
import com.example.moviesapp.data.Models.LoginResponse
import com.example.moviesapp.data.Models.MoviesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
//https://our-movie-service.herokuapp.com/Movies/getmovies
//https://our-movie-service.herokuapp.com/Users/login
//https://our-movie-service.herokuapp.com/Users/register

interface Apis {
//    @POST("Users/register")
//    suspend fun register(@Body registerRequest: RegisterRequest): Response<RegisterResponse>

    @POST("Users/login")
    suspend fun login(@Body loginRequest: LoginRequest):Response<LoginResponse>
    @GET("Movies/getmovies")
     fun getAllMovies(): Call<ArrayList<MoviesResponse>>

}

var retrofit = Retrofit.Builder()
    .baseUrl("https://our-movie-service.herokuapp.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
var service :Apis = retrofit.create(Apis::class.java)