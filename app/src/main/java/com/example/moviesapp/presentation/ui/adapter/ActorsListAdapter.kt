package com.example.moviesapp.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.data.Models.ActorModel
import de.hdodenhof.circleimageview.CircleImageView

class ActorsListAdapter(val onActorClick: (ActorModel) -> Unit = { a -> }) : ListAdapter<ActorModel, ActorsListAdapter.ActorViewHolder>(
  ActorDiffCallback()
) {

  // view Holder Which hold view
  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ActorViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.actor_component, parent, false)
    val viewHolder = ActorViewHolder(view)
    viewHolder.itemView.setOnClickListener {onActorClick(getItem(viewHolder.adapterPosition))}
    return viewHolder
  }

  override fun onBindViewHolder(
    holder: ActorViewHolder,
    position: Int
  ) {
    holder.bind(getItem(position))
  }

  class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val actorImage = itemView.findViewById<CircleImageView>(R.id.profile_image)
    private val actorName = itemView.findViewById<TextView>(R.id.tv_name)
    fun bind(item: ActorModel)
    {
      actorName.text = item.name
      Glide.with(actorImage).load(R.drawable.download).into(actorImage)
    }
  }

  private class ActorDiffCallback : DiffUtil.ItemCallback<ActorModel>() {
    override fun areContentsTheSame(
      oldItem: ActorModel,
      newItem: ActorModel
    ): Boolean {
      return oldItem == newItem
    }

    override fun areItemsTheSame(
      oldItem: ActorModel,
      newItem: ActorModel
    ): Boolean {
      return oldItem.id == newItem.id
    }
  }
}