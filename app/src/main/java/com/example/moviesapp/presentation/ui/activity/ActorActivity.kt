package com.example.moviesapp.presentation.ui.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesapp.R
import com.example.moviesapp.presentation.ViewModels.ActorModel
import de.hdodenhof.circleimageview.CircleImageView

class ActorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor)

        val actor = intent.getParcelableExtra<ActorModel>("Actor")
        if(actor!=null){

            val name :TextView = findViewById(R.id.actor_name)
            val image : CircleImageView = findViewById(R.id.profile_image)
            //val moviesList :TextView = findViewById(R.id.moviesList)

            val acName =actor.name
            val acImage=actor.image
            val acMovies=actor.moviesList
            val acID=actor.id

            name.text=acName
            image.setImageResource(acImage)
            //moviesList.text=acMovies


        }

    }
}