package com.example.moviesapp.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.moviesapp.R
import com.example.moviesapp.presentation.ui.fragment.ActorsFragment
import com.example.moviesapp.presentation.ui.fragment.FavoritesFragment
import com.example.moviesapp.presentation.ui.fragment.MoviesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    var saved:Fragment?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesFragment= MoviesFragment()
        val actorsFragment=ActorsFragment()
        val favoritesFragment=FavoritesFragment()
        if(saved==null) {
            saved=moviesFragment
            setCurrentFragment(moviesFragment)
        }else{
            println(saved)
            setCurrentFragment(saved!!)
        }

        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_movies-> {
                   saved=moviesFragment
                    setCurrentFragment(moviesFragment)
                }
                R.id.navigation_actors-> {
                    saved=actorsFragment
                    setCurrentFragment(actorsFragment)
                }
                R.id.navigation_fav-> {
                    saved=favoritesFragment
                    setCurrentFragment(favoritesFragment)
                }

            }
            true
        }

    }

//    override fun onResume() {
//        super.onResume()

//        setCurrentFragment(saved!!)
//    }
    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.f,fragment)
            commit()
        }
    }
}