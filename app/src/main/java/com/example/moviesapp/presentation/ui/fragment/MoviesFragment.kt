package com.example.moviesapp.presentation.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.data.Models.MoviesResponse
import com.example.moviesapp.data.Network.service
import com.example.moviesapp.presentation.ViewModels.MovieModel
import com.example.moviesapp.presentation.ui.activity.MovieActivity
import com.example.moviesapp.presentation.ui.adapter.MoviesListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    private lateinit var moviesAdapter: MoviesListAdapter
    private lateinit var recyclerView: RecyclerView
    var moviesList1: ArrayList<MoviesResponse>? = null
    var liveData: ArrayList<MovieModel>? = null

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesAdapter = MoviesListAdapter(listOf())

        val layout = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layout
        recyclerView.adapter = moviesAdapter

        moviesList1 = ArrayList()
        getData()
        moviesAdapter = MoviesListAdapter(moviesList1!!)
        recyclerView.adapter = moviesAdapter

        moviesAdapter.onItemClick = {
            val intent = Intent(context, MovieActivity::class.java)
            intent.putExtra("Movie", it)
            startActivity(intent)
        }


    }

    private fun getData() {
        service.getAllMovies().enqueue(object : Callback<ArrayList<MoviesResponse>> {
            override fun onResponse(
                call: Call<ArrayList<MoviesResponse>>,
                response: Response<ArrayList<MoviesResponse>>
            ) {
                if (response.isSuccessful) {
                    moviesAdapter.moviesList = response.body()
                    recyclerView?.adapter = moviesAdapter
                }
            }

            override fun onFailure(call: Call<ArrayList<MoviesResponse>>, t: Throwable) {
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
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

