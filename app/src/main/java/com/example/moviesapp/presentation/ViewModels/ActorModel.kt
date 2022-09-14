package com.example.moviesapp.presentation.ViewModels
import android.os.Parcel
import android.os.Parcelable

data class ActorModel(
    val image:Int,
    val name:String,
    val id:Int,
    val moviesList:String):Parcelable { //id,name,image,listofmovies

    constructor(parcel: Parcel):this(
        parcel.readInt()!!,
        parcel.readString().toString()!!,
        parcel.readInt()!!,
        parcel.readString().toString()!!
    )
    override fun describeContents(): Int {
      return 0 }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeInt(id)
        parcel.writeString(moviesList)
    }

    companion object CREATOR : Parcelable.Creator<ActorModel> {
        override fun createFromParcel(parcel: Parcel): ActorModel {
            return ActorModel(parcel)
        }

        override fun newArray(size: Int): Array<ActorModel?> {
            return arrayOfNulls(size)
        }
    }


}