package com.example.moviesapp.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesapp.R

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val regBtn = findViewById<Button>(R.id.tv_register2)
        regBtn.setOnClickListener {
            val intent=Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        val loginBtn2=findViewById<Button>(R.id.loginBtn2)
         val email = findViewById<EditText>(R.id.et_email2)
         val pass = findViewById<EditText>(R.id.et_password2)
        loginBtn2.setOnClickListener {
            if(email.text.isNotBlank()&&pass.text.isNotBlank()){

                val intent3=Intent(this, MainActivity::class.java)
                startActivity(intent3)
            }else{
                Toast.makeText(this,"Required field!!",Toast.LENGTH_SHORT).show()
            }

        }
    }



}