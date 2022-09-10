package com.example.moviesapp.Movies_Adapter

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.moviesapp.R
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class DetailedMovieActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_movie)


        val movie = intent.getParcelableExtra<Movies>("Movie")
        if(movie != null){
            val textViewName : TextView =  findViewById(R.id.tv_movie_name)
            val textViewCategory : TextView =  findViewById(R.id.tv_movie_category)
            val textViewTime : TextView =  findViewById(R.id.tv_movie_time)
            val textViewYear : TextView =  findViewById(R.id.tv_movie_year)
            val textViewDirector : TextView =  findViewById(R.id.tv_movie_director)
            val textViewDescription : TextView =  findViewById(R.id.tv_movie_description)
            val textViewRating : TextView =  findViewById(R.id.tv_movie_rating)

            val imageView : ImageView =  findViewById(R.id.iv_poster_detailed)

            val Mname = movie.name
            val Mcategory = movie.category
            val Mtime = movie.time
            val Myear = movie.year
            val Mdirector = movie.director
            val Mrating = movie.rating
            val Mdescr = movie.description
            val Mtrailer = movie.trailer


            textViewName.text = "Title: $Mname"
            textViewCategory.text = "Category: $Mcategory"
            textViewTime.text = "Time: $Mtime"
            textViewYear.text = "Year: $Myear"
            textViewDirector.text = "Director: $Mdirector"
            textViewRating.text = "Rating: $Mrating"
            textViewDescription.text = Mdescr
            imageView.setImageResource(movie.image)
        }

    }
}