package com.example.moviesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.moviesapp.register_screen.RegisterActivity
<<<<<<< HEAD
import com.example.moviesapp.splash_screen.SplashScreenActivity
=======
import com.google.android.material.bottomnavigation.BottomNavigationView
>>>>>>> 17b42baad7a468f6bfced03b22ab6908cb23c1aa

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn=findViewById<Button>(R.id.toRegister)
        btn.setOnClickListener {
            val intent =Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        val navController = findNavController(R.id.fl_framelayout)
    }
}