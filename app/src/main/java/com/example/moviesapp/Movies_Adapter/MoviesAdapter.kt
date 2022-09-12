package com.example.moviesapp.Movies_Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R

class MoviesAdapter(private val moviesList:ArrayList<Movies>)
    : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>()
{
    var onItemClick : ((Movies) -> Unit)? = null

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val poster: ImageView = itemView.findViewById(R.id.iv_poster)
        val name: TextView = itemView.findViewById(R.id.tv_name)
        val time: TextView = itemView.findViewById(R.id.tv_time)
        val category: TextView = itemView.findViewById(R.id.tv_category)
        val year: TextView = itemView.findViewById(R.id.tv_year)
//        val rating: RatingBar = itemView.findViewById(R.id.rat_score)
        val tvRating : TextView = itemView.findViewById((R.id.tv_rating))


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return MoviesViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int)
    {
        val movies = moviesList[position]
        holder.poster.setImageResource(movies.image)
        holder.name.text = movies.name
        holder.time.text = "        ${movies.time}"
        holder.category.text = "        ${movies.category}"
        holder.year.text = "        ${movies.year}"
        holder.tvRating.text = "        ${movies.rating.toFloat()}"
//        holder.rating.rating = movies.rating.toFloat()

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(movies)
        }
    }

    override fun getItemCount(): Int
    {
        return moviesList.size
    }
}