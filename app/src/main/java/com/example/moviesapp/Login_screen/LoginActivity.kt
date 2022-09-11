package com.example.moviesapp.Login_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.moviesapp.Movies_Adapter.MoviesHome
import com.example.moviesapp.R
import com.example.moviesapp.register_screen.RegisterActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val ca = findViewById<Button>(R.id.CreateAc)
        ca.setOnClickListener {
            val intnt=Intent(this,RegisterActivity::class.java)
            startActivity(intnt)
        }
        val loginbt=findViewById<Button>(R.id.loginbt)
        loginbt.setOnClickListener {
            val intent3=Intent(this,MoviesHome::class.java)
            startActivity(intent3)
        }
    }}