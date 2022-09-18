package com.example.moviesapp.data.singlton

import com.example.moviesapp.presentation.ViewModels.MovieModel

class Favorites {

    companion object {
        var favList: ArrayList<MovieModel> = ArrayList()
    }

    fun add(movieModel: MovieModel) {
        favList.add(movieModel)
    }

    fun remove(movieModel: MovieModel) {
        favList.remove(movieModel)
    }

    fun getAllList(): ArrayList<MovieModel> {
        return favList
    }

    fun found(movieModel: MovieModel): Boolean {
        return movieModel in favList
    }

}