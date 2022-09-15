package com.example.moviesapp.data.singlton

class User {
    companion object{
        private var username:String=""
        private var userId :Int=0
        private var email:String=""
        private var password:String=""
    }
    fun delete(){
        username=""
        userId=0
        email=""
        password=""
    }
    fun setUser(_username:String,_userID:Int,_email:String,_pass:String,){
        username=_username
        userId=_userID
        email=_email
        password=_pass
    }
    fun getID():Int{
        return userId
    }
    fun getEmail():Int{
        return userId
    }
}