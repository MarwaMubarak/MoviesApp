package com.example.moviesapp.data.Models
import com.google.gson.annotations.SerializedName

 data class ActorsResponse (
        @SerializedName("actorId"       ) var actorId       : Int?                   = null,
        @SerializedName("actorName"     ) var actorName     : String?                = null,
        @SerializedName("actorImageUrl" ) var actorImageUrl : String?                = null,
        @SerializedName("age"           ) var age           : String?                = null,
        @SerializedName("height"        ) var height        : String?                = null,
        @SerializedName("actorMovies"   ) var actorMovies   : ArrayList<MoviesResponse> = arrayListOf()
 )