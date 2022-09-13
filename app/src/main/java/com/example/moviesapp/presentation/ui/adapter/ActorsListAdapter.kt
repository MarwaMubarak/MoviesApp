package com.example.moviesapp.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R

class ActorsListAdapter: RecyclerView.Adapter<ActorsListAdapter.ViewHolder>() {

    private var texts = arrayOf(
        "Karim Abdelazeez",
        "Ahmed Ezz",
        "Tobey Macguir",
        "Jonney Cage",
        "text6",
        "text7",
        "text9",
        "text10"
    )
    private var images = arrayOf(
        R.drawable.download,
        R.drawable.download,
        R.drawable.download,
        R.drawable.download,
        R.drawable.download,
        R.drawable.download,
        R.drawable.download,
        R.drawable.download,
        R.drawable.download,
        R.drawable.download
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.actor_component, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtv.text=texts[position]
        holder.itimg.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return texts.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itimg: ImageView
        var txtv: TextView

        init {
            itimg = itemView.findViewById(R.id.profile_image)
            txtv = itemView.findViewById(R.id.tv_name)


        }
    }
}