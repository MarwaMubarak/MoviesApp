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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesFragment= MoviesFragment()
        val actorsFragment=ActorsFragment()
        val favoritesFragment=FavoritesFragment()

        setCurrentFragment(moviesFragment)

        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_movies-> {
                    setCurrentFragment(moviesFragment)
                }
                R.id.navigation_actors-> {
                    setCurrentFragment(actorsFragment)
                }
                R.id.navigation_fav-> {
                    setCurrentFragment(favoritesFragment)
                }

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.f,fragment)
            commit()
        }
    }
}