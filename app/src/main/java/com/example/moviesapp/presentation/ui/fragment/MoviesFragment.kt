package com.example.moviesapp.presentation.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.presentation.ViewModels.MovieModel
import com.example.moviesapp.presentation.ui.activity.MovieActivity
import com.example.moviesapp.presentation.ui.adapter.MoviesListAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MoviesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class MoviesFragment : Fragment(R.layout.fragment_movies) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var moviesList: ArrayList<MovieModel>
    private lateinit var moviesAdapter: MoviesListAdapter
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        moviesList = ArrayList()

        moviesList.add(
            MovieModel(R.drawable.avengers_endgame, "Avengers: Endgame", "3h6m",
                "Action", "Russo Brother","2019",
                "Hello This is a movie", "JfVOs4VSpmA", 5.0)
        )
        moviesList.add(
            MovieModel(R.drawable.joker, "Joker", "2h",
                "Comedy", "Steven","2020",
                "Hello This is a movie", "JfVOs4VSpmA",3.5)
        )
        moviesList.add(
            MovieModel(R.drawable.spiderman_nowayhome, "Spiderman: No Way Home", "2h30m",
                "Action", "Russo Brother","2022",
                "Hello This is ajshfghisgkhsgsifhgsifgsigfiwrgfigfrifgr movie", "JfVOs4VSpmA",5.0)
        )
        moviesList.add(
            MovieModel(R.drawable.the_batman, "The Batman", "2h30m",
                "Action", "Kevin","2022",
                "Hello This is a movie","JfVOs4VSpmA", 3.5)
        )
        moviesList.add(
            MovieModel(R.drawable.the_irishman, "The Irishman", "3h",
                "Mystery", "Abdelrahman","2019",
                "Hello This is ajshfghisgkhsgsifhgsifgsigfiwrgfigfrifgra movie", "JfVOs4VSpmA", 2.5)
        )

        moviesList.add(
            MovieModel(R.drawable.avengers_endgame, "Avengers: Endgame", "3h6m",
                "Action", "Russo Brother","2019",
                "Hello This is a movie","JfVOs4VSpmA", 5.0)
        )
        moviesList.add(
            MovieModel(R.drawable.joker, "Joker", "2h",
                "Comedy", "Steven","2020",
                "Hello This is a ajshfghisgkhsgsifhgsifgsigfiwrgfigfrifgrmovie","JfVOs4VSpmA",3.5)
        )
        moviesList.add(
            MovieModel(R.drawable.spiderman_nowayhome, "Spiderman: No Way Home", "2h30m",
                "Action", "Russo Brother","2022",
                "Hello This is a movie","JfVOs4VSpmA",5.0)
        )
        moviesList.add(
            MovieModel(R.drawable.the_batman, "The Batman", "2h30m",
                "Action", "Kevin","2022",
                "Hello This is a movie","JfVOs4VSpmA",3.5)
        )
        moviesList.add(
            MovieModel(R.drawable.the_irishman, "The Irishman", "3h",
                "Mystery", "Abdelrahman","2019",
                "Hello This is a movie","JfVOs4VSpmA",2.5)
        )

        moviesAdapter = MoviesListAdapter(moviesList)
        recyclerView.adapter = moviesAdapter

        moviesAdapter.onItemClick = {
            val intent = Intent(context, MovieActivity::class.java)
            intent.putExtra("Movie", it)
            startActivity(intent)
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MoviesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MoviesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}