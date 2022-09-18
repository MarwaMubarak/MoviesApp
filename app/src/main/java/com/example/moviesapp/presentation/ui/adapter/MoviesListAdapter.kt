package com.example.moviesapp.presentation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.data.Models.MoviesResponse
import com.example.moviesapp.presentation.ViewModels.MovieModel
import com.squareup.picasso.Picasso

class MoviesListAdapter(var moviesList: List<MoviesResponse?>?) :
    RecyclerView.Adapter<MoviesListAdapter.MoviesViewHolder>() {
    var onItemClick: ((MovieModel) -> Unit)? = null

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val poster: ImageView = itemView.findViewById(R.id.iv_poster)
        val name: TextView = itemView.findViewById(R.id.tv_name)
        val time: TextView = itemView.findViewById(R.id.tv_time)
        val category: TextView = itemView.findViewById(R.id.tv_category)
        val year: TextView = itemView.findViewById(R.id.tv_year)
        val tvRating: TextView = itemView.findViewById((R.id.tv_rating))


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_component, parent, false)
        return MoviesViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = moviesList?.get(position)
        Picasso.get().load(movies?.movieImageUrl).into(holder.poster)
        holder.name.text = movies?.movieName
        holder.time.text = "        ${movies?.movieDuration}"
        holder.category.text = "        ${movies?.movieCategory}"
        holder.year.text = "        ${movies?.movieProductionYear}"
        holder.tvRating.text = "        ${movies?.movieRating?.toFloat()}"

        holder.itemView.setOnClickListener {
            val movieModel = MovieModel(
                name = movies?.movieName,
                category = movies?.movieCategory,
                time = movies?.movieDuration,
                director = movies?.directorName,
                year = movies?.movieProductionYear,
                description = movies?.movieDescription,
                rating = movies?.movieRating,
                trailer = movies?.movieVideoUrl,
                image = movies?.movieImageUrl
            )
            onItemClick?.invoke(movieModel)
        }
    }

    override fun getItemCount(): Int {
        return moviesList?.size ?: 0
    }
}