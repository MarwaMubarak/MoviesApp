package com.example.moviesapp.presentation.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.data.Models.ActorModel
import com.example.moviesapp.presentation.ui.activity.ActorDetailsActivity
import com.example.moviesapp.presentation.ui.navigation.ActorsFragmentNavigation
import com.example.moviesapp.presentation.view_model.ActorsViewModel

class ActorsFragment : Fragment(R.layout.fragment_actors), ActorsFragmentNavigation {

  private lateinit var recyclerView: RecyclerView
  private val actorsViewModel: ActorsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actorsViewModel.actorFragmentCallBack = this
        actorsViewModel.setAdapterData()
    }
  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    recyclerView = view.findViewById(R.id.rv3)
    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager = LinearLayoutManager(context)
    recyclerView.adapter = actorsViewModel.actorAdapter
  }

  override fun openActorsDetailsOnClick(actor: ActorModel)
  {
   activity?.startActivity(Intent(activity,ActorDetailsActivity::class.java))
  }
}