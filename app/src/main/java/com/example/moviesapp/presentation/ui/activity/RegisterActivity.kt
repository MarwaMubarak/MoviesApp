package com.example.moviesapp.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesapp.R
import com.example.moviesapp.data.Models.RegisterRequest
import com.example.moviesapp.data.Network.service
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                        register(password.text.toString(),email.text.toString(),username.text.toString())
//                    val intent = Intent(this, MainActivity::class.java)
//                    Toast.makeText(this, "Successful Registration..", Toast.LENGTH_SHORT).show()
//                    startActivity(intent)
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
    private fun register( _pass:String ,_email:String ,_username:String){
        service.register(RegisterRequest(_username,_pass,_email)).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    val resp=response.body()
                    println("---------------------------------------------------------------")
                    println(response.body())
                    println("---------------------------------------------------------------")

                    Toast.makeText(this@RegisterActivity,"Successful Registration!!",Toast.LENGTH_SHORT).show()
                    val intent3=Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(intent3)
                }else{
                    Toast.makeText(this@RegisterActivity,"Invalid Registration!!", Toast.LENGTH_SHORT).show()

                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(this@RegisterActivity,t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }

}