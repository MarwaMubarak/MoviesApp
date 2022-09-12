package com.example.moviesapp.Movies_Adapter

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.moviesapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class DetailedMovieActivity : YouTubeBaseActivity() {

    val YOUTUBE_API_KEY = "AIzaSyDsBGIkjg7UVhMLaAE_q_v8-vxHna3gOMI"


    private lateinit var youTubePlayer: YouTubePlayerView
    private lateinit var btnPlay : Button

    lateinit var youTubePlayerInit : YouTubePlayer.OnInitializedListener

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_movie)


        val movie = intent.getParcelableExtra<Movies>("Movie")
        if(movie != null){
            val textViewName : TextView =  findViewById(R.id.tv_movie_name)
            val textViewCategory : TextView =  findViewById(R.id.tv_movie_category)
            val textViewYear : TextView =  findViewById(R.id.tv_movie_year_time)
            val textViewDirector : TextView =  findViewById(R.id.tv_movie_director)
            val textViewDescription : TextView =  findViewById(R.id.tv_movie_description)
            val textViewRating : TextView =  findViewById(R.id.tv_movie_rating)

            val Mname = movie.name
            val Mcategory = movie.category
            val Mtime = movie.time
            val Myear = movie.year
            val Mdirector = movie.director
            val Mrating = movie.rating
            val Mdescr = movie.description
            val Mtrailer = movie.trailer


            textViewName.text = Mname
            textViewCategory.text = Mcategory
            textViewYear.text = "$Myear - $Mtime"
            textViewDirector.text = "Director - $Mdirector"
            textViewRating.text = Mrating.toString()
            textViewDescription.text = "Description: $Mdescr"

            youTubePlayer = findViewById(R.id.youtubePlayer)

            btnPlay = findViewById(R.id.btnPlay)

            youTubePlayerInit = object :  YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubePlayer?,
                    p2: Boolean
                ) {
                    p1?.loadVideo(Mtrailer)
                }

                override fun onInitializationFailure(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubeInitializationResult?
                ) {
                    Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                }

            }
            btnPlay.setOnClickListener{
                youTubePlayer.initialize(YOUTUBE_API_KEY, youTubePlayerInit)
            }
        }
    }
}