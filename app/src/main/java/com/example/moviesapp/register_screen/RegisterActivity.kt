package com.example.moviesapp.register_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.moviesapp.Login_screen.LoginActivity
import com.example.moviesapp.Movies_Adapter.MoviesHome
import com.example.moviesapp.R
import java.time.Duration

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val username=findViewById<EditText>(R.id.et_username)
        val email=findViewById<EditText>(R.id.et_email)
        val password=findViewById<EditText>(R.id.et_password)
        val confirmPassword=findViewById<EditText>(R.id.et_confirmPassword)



        val btn=findViewById<Button>(R.id.registerBtn)
        btn.setOnClickListener {
            if(username.text.isNotBlank()&&password.text.isNotBlank()&&email.text.isNotBlank()&&confirmPassword.text.isNotBlank()){
                if(!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
                    Toast.makeText(this,"Invalid Email !!", Toast.LENGTH_SHORT).show()

                }
                else if(!password.text.toString().equals(confirmPassword.text.toString())){
                    Toast.makeText(this,"Password does not match!!", Toast.LENGTH_SHORT).show()

                }else {
                    val intent = Intent(this, MoviesHome::class.java)
                    Toast.makeText(this, "Successful Registration..", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }
            }
            else{
                Toast.makeText(this,"Empty Field!!", Toast.LENGTH_SHORT).show()
            }

        }

        val logBtn=findViewById<Button>(R.id.tv_login)
        logBtn.setOnClickListener {
            val intent1=Intent(this, LoginActivity::class.java)
            startActivity(intent1)

        }
    }
}