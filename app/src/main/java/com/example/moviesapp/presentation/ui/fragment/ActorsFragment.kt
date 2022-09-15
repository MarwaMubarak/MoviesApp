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
import com.example.moviesapp.data.Models.ActorsResponse
import com.example.moviesapp.data.Network.service
import com.example.moviesapp.presentation.ViewModels.MovieModel
import com.example.moviesapp.presentation.ui.activity.ActorActivity
import com.example.moviesapp.presentation.ui.adapter.ActorsListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ActorsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ActorsFragment : Fragment(R.layout.fragment_actors) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var actorsAdapter: ActorsListAdapter
    private lateinit var recyclerView: RecyclerView
    var actorsList: ArrayList<ActorsResponse>?=null
    var moviesList: ArrayList<MovieModel> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actorsAdapter= ActorsListAdapter(listOf())
        val layout =LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv3)
        recyclerView.layoutManager=layout
        recyclerView.adapter=actorsAdapter
        recyclerView.setHasFixedSize(true)
        moviesList = ArrayList()
        actorsList = ArrayList()

        getData()
        actorsAdapter = ActorsListAdapter(actorsList!!)
        recyclerView.adapter = actorsAdapter

        actorsAdapter.onItemClick = {
            val intent = Intent(context, ActorActivity::class.java)
            intent.putExtra("Actor", it)
            startActivity(intent)
        }


    }

    private fun getData() {
        service.getAllActors().enqueue(object : Callback<ArrayList<ActorsResponse>> {
            override fun onResponse(call: Call<ArrayList<ActorsResponse>>, response: Response<ArrayList<ActorsResponse>>) {

                println("-------------------------------------------------------------------------")
                println(response.code())
                println("-------------------------------------------------------------------------")

                if (response.isSuccessful) {
                    actorsAdapter.actorsList=response.body()
                    actorsList= response.body()
                    recyclerView?.adapter=actorsAdapter
                }

            }

            override fun onFailure(call: Call<ArrayList<ActorsResponse>>, t: Throwable) {
                Toast.makeText(requireContext(),t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_actors, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ActorsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ActorsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

//        moviesList.add(
//            MovieModel(
//                image = R.drawable.avengers_endgame, "Avengers: Endgame", "3h6m",
//                "Action", "Russo Brother", "2019",
//                "Hello This is a movie", "JfVOs4VSpmA", 5.0
//            )
//        )
//        moviesList.add(
//            MovieModel(
//                R.drawable.joker, "Joker", "2h",
//                "Comedy", "Steven", "2020",
//                "Hello This is a movie", "JfVOs4VSpmA", 3.5
//            )
//        )
//        moviesList.add(
//            MovieModel(
//                R.drawable.spiderman_nowayhome, "Spiderman: No Way Home", "2h30m",
//                "Action", "Russo Brother", "2022",
//                "Hello This is ajshfghisgkhsgsifhgsifgsigfiwrgfigfrifgr movie", "JfVOs4VSpmA", 5.0
//            )
//        )
//        moviesList.add(
//            MovieModel(
//                R.drawable.the_batman, "The Batman", "2h30m",
//                "Action", "Kevin", "2022",
//                "Hello This is a movie", "JfVOs4VSpmA", 3.5
//            )
//        )
//        moviesList.add(
//            MovieModel(
//                R.drawable.the_irishman, "The Irishman", "3h",
//                "Mystery", "Abdelrahman", "2019",
//                "Hello This is ajshfghisgkhsgsifhgsifgsigfiwrgfigfrifgra movie", "JfVOs4VSpmA", 2.5
//            )
//        )

//
//
//actorsList = ArrayList()
//actorsList.add(
//ActorModel(
//name = "Kareem Abdelaziz",
//image = R.drawable.download,
//id = 1,
//moviesList = moviesList
//)
//)
//actorsList.add(
//ActorModel(
//name = "Kareem Abdelaziz",
//image = R.drawable.download,
//id = 1,
//moviesList = moviesList
//)
//)
//actorsList.add(
//ActorModel(
//name = "Kareem Abdelaziz",
//image = R.drawable.download,
//id = 1,
//moviesList = moviesList
//)
//)
//actorsList.add(
//ActorModel(
//name = "Kareem Abdelaziz",
//image = R.drawable.download,
//id = 1,
//moviesList = moviesList
//)
//)
//actorsList.add(
//ActorModel(
//name = "Kareem Abdelaziz",
//image = R.drawable.download,
//id = 1,
//moviesList = moviesList
//)
//)
//actorsList.add(
//ActorModel(
//name = "Kareem Abdelaziz",
//image = R.drawable.download,
//id = 1,
//moviesList = moviesList
//)
//)
//actorsList.add(
//ActorModel(
//name = "Kareem Abdelaziz",
//image = R.drawable.download,
//id = 1,
//moviesList = moviesList
//)
//)