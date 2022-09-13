package com.example.moviesapp.presentation.ViewModels

import android.os.Parcel
import android.os.Parcelable

data class MovieModel (val image: Int,
                       val name: String,
                       val time: String,
                       val category: String,
                       val director: String,
                       val year: String,
                       val description: String,
                       val trailer: String,
                       val rating: Double) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt()!!,
        parcel.readString().toString()!!,
        parcel.readString().toString()!!,
        parcel.readString().toString()!!,
        parcel.readString().toString()!!,
        parcel.readString().toString()!!,
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readDouble()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(time)
        parcel.writeString(category)
        parcel.writeString(director)
        parcel.writeString(year)
        parcel.writeString(description)
        parcel.writeString(trailer)
        parcel.writeDouble(rating)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieModel> {
        override fun createFromParcel(parcel: Parcel): MovieModel {
            return MovieModel(parcel)
        }

        override fun newArray(size: Int): Array<MovieModel?> {
            return arrayOfNulls(size)
        }
    }
}
