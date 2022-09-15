package com.example.moviesapp.presentation.ui.activity

import FavListAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.presentation.ViewModels.ActorModel
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class ActorActivity : AppCompatActivity() {
    private lateinit var moviesAdapter: FavListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor)

        val actor = intent.getParcelableExtra<ActorModel>("Actor")
        if(actor!=null){
            val acName =actor.name
            val acImage=actor.image


            val name :TextView = findViewById(R.id.actor_name)
            val image : CircleImageView = findViewById(R.id.profile_image)
            val moviesRec :RecyclerView = findViewById(R.id.rv_movies_in_actor)

            moviesAdapter=FavListAdapter(listOf())
            val layout = LinearLayoutManager(this)
            moviesRec.layoutManager=layout
            moviesRec.adapter=moviesAdapter
            val acMovies=actor.moviesList
            moviesAdapter=FavListAdapter(acMovies!!)
            moviesRec.adapter=moviesAdapter
            moviesAdapter.onItemClick = {
                val intent = Intent(this, MovieActivity::class.java)
                intent.putExtra("Movie", it)
                startActivity(intent)
            }
            Picasso.get().load(acImage).into(image)
            name.text=acName


        }

    }
}