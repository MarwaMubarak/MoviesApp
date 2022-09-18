package com.example.moviesapp.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesapp.R
import com.example.moviesapp.data.Models.LoginRequest
import com.example.moviesapp.data.Models.LoginResponse
import com.example.moviesapp.data.Network.service
import com.example.moviesapp.data.singlton.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {


    private var user: User = User()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val email = findViewById<EditText>(R.id.et_email2)
        val pass = findViewById<EditText>(R.id.et_password2)
        val regBtn = findViewById<Button>(R.id.tv_register2)
        regBtn.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val loginBtn2 = findViewById<Button>(R.id.loginBtn2)

        loginBtn2.setOnClickListener {
            if (email.text.isNotBlank() && pass.text.isNotBlank()) {


                val _pass = pass.text.toString()
                val _email = email.text.toString()
                login(_pass, _email)

            } else {
                Toast.makeText(this, "Required field!!", Toast.LENGTH_SHORT).show()
            }

        }
    }


    private fun login(_pass: String, _email: String) {
        service.login(LoginRequest(_email, _pass)).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val resp = response.body()
                    user.setUser(
                        _username = "Marwa",
                        _email = resp!!.email,
                        _pass = resp!!.password,
                        _userID = resp!!.id
                    )
                    Toast.makeText(this@LoginActivity, "Login Successfully!!", Toast.LENGTH_SHORT)
                        .show()
                    val intent3 = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent3)
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Invalid Email or Password!!",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }


}