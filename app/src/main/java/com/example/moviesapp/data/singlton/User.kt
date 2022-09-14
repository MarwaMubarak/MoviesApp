package com.example.moviesapp.data.singlton

class User {
    companion object{
        private var username:String=""
        private var userId :String=""
        private var email:String=""
        private var password:String=""
    }
    fun delete(){
        username=""
        userId=""
        email=""
        password=""
    }
    fun setUser(_username:String,_userID:String,_email:String,_pass:String,){
        username=_username
        userId=_userID
        email=_email
        password=_pass
    }
    fun getID():String{
        return userId
    }
    fun getEmail():String{
        return userId
    }
}