package com.example.moviesapp.presentation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.data.Models.ActorsResponse
import com.example.moviesapp.presentation.ViewModels.ActorModel
import com.example.moviesapp.presentation.ViewModels.MovieModel
import com.squareup.picasso.Picasso

class ActorsListAdapter(var actorsList:List<ActorsResponse?>?)
    : RecyclerView.Adapter<ActorsListAdapter.ActorsViewHolder>() {
    var onItemClick : ((ActorModel) -> Unit)? = null
     class ActorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val image: ImageView = itemView.findViewById(R.id.profile_image)
         val name: TextView = itemView.findViewById(R.id.tv_name)

     }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ActorsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.actor_component, parent, false)
        return ActorsViewHolder(v)
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
        val actor1 =actorsList?.get(position)
        holder.name.text=actor1?.actorName
        Picasso.get().load(actor1?.actorImageUrl).into(holder.image)

        var movies:ArrayList<MovieModel> = ArrayList()
        for (x in actor1!!.actorMovies ){
            val mov=MovieModel(
                name = x?.movieName,
                category = x?.movieCategory,
                time =  x?.movieDuration,
                director = x?.directorName,
                year = x?.movieProductionYear,
                description = x?.movieDescription,
                rating = x?.movieRating,
                trailer = x?.movieVideoUrl,
                image = x?.movieImageUrl
            )
            movies.add(mov)
        }
        holder.itemView.setOnClickListener{
            val actor = ActorModel(
                image = actor1?.actorImageUrl,
                moviesList = movies,
                name = actor1?.actorName,
                id =actor1?.actorId
            )
            onItemClick?.invoke(actor)
        }
    }

    override fun getItemCount(): Int {
        return actorsList?.size?:0
    }


}