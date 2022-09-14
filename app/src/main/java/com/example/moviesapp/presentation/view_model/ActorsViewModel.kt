package com.example.moviesapp.presentation.view_model

import androidx.lifecycle.ViewModel
import com.example.moviesapp.R.drawable
import com.example.moviesapp.data.Models.ActorModel
import com.example.moviesapp.presentation.ui.adapter.ActorsListAdapter
import com.example.moviesapp.presentation.ui.navigation.ActorsFragmentNavigation

class ActorsViewModel : ViewModel() {
  var actorFragmentCallBack: ActorsFragmentNavigation? = null
  val actorAdapter = ActorsListAdapter(::onItemClicked)
  private fun onItemClicked(actorModel: ActorModel) { actorFragmentCallBack?.openActorsDetailsOnClick(actorModel)}

  fun setAdapterData() {
    val list = actorAdapter.currentList.toMutableList()
    list.clear()
    list.addAll(getActorsList())
    actorAdapter.submitList(list)
  }

  private fun getActorsList(): List<ActorModel> {
    return listOf(
      ActorModel(
        name = "Kareem Abdelaziz", image = drawable.download, id = 1, moviesList = "El Basha Telmiz"
      ),
      ActorModel(
        name = "Kareem Abdelaziz", image = drawable.download, id = 2, moviesList = "El Basha Telmiz"
      ),
      ActorModel(
        name = "Kareem Abdelaziz", image = drawable.download, id = 3, moviesList = "El Basha Telmiz"
      ),
      ActorModel(
        name = "Kareem Abdelaziz", image = drawable.download, id = 4, moviesList = "El Basha Telmiz"
      ),
      ActorModel(
        name = "Kareem Abdelaziz", image = drawable.download, id = 5, moviesList = "El Basha Telmiz"
      ),
      ActorModel(
        name = "Kareem Abdelaziz", image = drawable.download, id = 6, moviesList = "El Basha Telmiz"
      )
    )
  }
}