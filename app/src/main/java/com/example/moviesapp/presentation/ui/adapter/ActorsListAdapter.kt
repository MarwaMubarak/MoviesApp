package com.example.moviesapp.presentation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.presentation.ViewModels.ActorModel

class ActorsListAdapter(private val actorsList:ArrayList<ActorModel>)
    : RecyclerView.Adapter<ActorsListAdapter.ActorsViewHolder>() {
    var onItemClick : ((ActorModel) -> Unit)? = null
     class ActorsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val image: ImageView = itemView.findViewById(R.id.profile_image)
         val name: TextView = itemView.findViewById(R.id.tv_name)
        // val movies: TextView = itemView.findViewById(R.id.moviesList)


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
        holder.name.text=actorsList[position].name
        holder.image.setImageResource(actorsList[position].image)
        //holder.movies.text=actorsList[position].moviesList
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(actorsList[position])
        }
    }

    override fun getItemCount(): Int {
        return actorsList.size
    }


}