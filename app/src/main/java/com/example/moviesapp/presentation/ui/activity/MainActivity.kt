package com.example.moviesapp.presentation.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.moviesapp.R
import com.example.moviesapp.presentation.ui.fragment.ActorsFragment
import com.example.moviesapp.presentation.ui.fragment.FavoritesFragment
import com.example.moviesapp.presentation.ui.fragment.MoviesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    var saved:Fragment?=null
    private val TAG = "QuizActivity"
    private val KEY_INDEX = "index"
    var mCurrentIndex=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesFragment= MoviesFragment()
        val actorsFragment=ActorsFragment()
        val favoritesFragment=FavoritesFragment()
        if (savedInstanceState != null) {
             mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        when (mCurrentIndex) {

            0 -> {
                setCurrentFragment(MoviesFragment())
            }
            1 -> {
                setCurrentFragment(ActorsFragment())
            }
            2 -> {
                setCurrentFragment(FavoritesFragment())
            }
        }
        val bottomNavigationView=findViewById<BottomNavigationView>(R.id.navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_movies-> {
                    mCurrentIndex=0
                    setCurrentFragment(moviesFragment)
                }
                R.id.navigation_actors-> {
                    mCurrentIndex=1
                    setCurrentFragment(actorsFragment)
                }
                R.id.navigation_fav-> {
                    mCurrentIndex=2
                    setCurrentFragment(favoritesFragment)
                }

            }
            true
        }

    }


    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.i(TAG, "onSaveInstanceState")
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex)
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.f,fragment)
            commit()
        }
    }
}