package com.example.moviesapp.Movies_Adapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MoviesHome : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var moviesList: ArrayList<Movies>
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_home)

        recyclerView = findViewById(R.id.rv_movie)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        moviesList = ArrayList()

        moviesList.add(Movies(R.drawable.avengers_endgame, "Avengers: Endgame", "3h6m",
            "Action", "Russo Brother","2019",
            "Hello This is a movie", "JfVOs4VSpmA", 5.0))
        moviesList.add(Movies(R.drawable.joker, "Joker", "2h",
            "Comedy", "Steven","2020",
            "Hello This is a movie", "JfVOs4VSpmA",3.5))
        moviesList.add(Movies(R.drawable.spiderman_nowayhome, "Spiderman: No Way Home", "2h30m",
            "Action", "Russo Brother","2022",
            "Hello This is ajshfghisgkhsgsifhgsifgsigfiwrgfigfrifgr movie", "JfVOs4VSpmA",5.0))
        moviesList.add(Movies(R.drawable.the_batman, "The Batman", "2h30m",
            "Action", "Kevin","2022",
            "Hello This is a movie","JfVOs4VSpmA", 3.5))
        moviesList.add(Movies(R.drawable.the_irishman, "The Irishman", "3h",
            "Mystery", "Abdelrahman","2019",
            "Hello This is ajshfghisgkhsgsifhgsifgsigfiwrgfigfrifgra movie", "JfVOs4VSpmA", 2.5))

        moviesList.add(Movies(R.drawable.avengers_endgame, "Avengers: Endgame", "3h6m",
            "Action", "Russo Brother","2019",
            "Hello This is a movie","JfVOs4VSpmA", 5.0))
        moviesList.add(Movies(R.drawable.joker, "Joker", "2h",
            "Comedy", "Steven","2020",
            "Hello This is a ajshfghisgkhsgsifhgsifgsigfiwrgfigfrifgrmovie","JfVOs4VSpmA",3.5))
        moviesList.add(Movies(R.drawable.spiderman_nowayhome, "Spiderman: No Way Home", "2h30m",
            "Action", "Russo Brother","2022",
            "Hello This is a movie","JfVOs4VSpmA",5.0))
        moviesList.add(Movies(R.drawable.the_batman, "The Batman", "2h30m",
            "Action", "Kevin","2022",
            "Hello This is a movie","JfVOs4VSpmA",3.5))
        moviesList.add(Movies(R.drawable.the_irishman, "The Irishman", "3h",
            "Mystery", "Abdelrahman","2019",
            "Hello This is a movie","JfVOs4VSpmA",2.5))

        moviesAdapter = MoviesAdapter(moviesList)
        recyclerView.adapter = moviesAdapter

        moviesAdapter.onItemClick = {
            val intent = Intent(this, DetailedMovieActivity::class.java)
            intent.putExtra("Movie", it)

            startActivity(intent)
        }
    }
}