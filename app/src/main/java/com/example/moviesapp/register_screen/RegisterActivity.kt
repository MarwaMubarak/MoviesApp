package com.example.moviesapp.register_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.moviesapp.Login_screen.LoginActivity
import com.example.moviesapp.Movies_Adapter.MoviesHome
import com.example.moviesapp.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btn=findViewById<Button>(R.id.registerBtn)
        btn.setOnClickListener {
            val intent = Intent(this,MoviesHome::class.java)
            startActivity(intent)
        }

        val logbtn=findViewById<Button>(R.id.tv_login)
        logbtn.setOnClickListener {
            val intent1=Intent(this, LoginActivity::class.java)
            startActivity(intent1)

        }
    }
}