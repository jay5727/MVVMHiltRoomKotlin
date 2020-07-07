package com.jay.mvvmhiltkotlin.model.user

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "person")
data class PersonDetail(
        @PrimaryKey
        @SerializedName("email") val email: String,
        @SerializedName("login") val login: Login,
        var page: Int,//Added for pagination since API isn't supporting pagination with current page & Last page fields
        @SerializedName("gender") val gender: String,
        @SerializedName("name") val name: Name,
        @SerializedName("location") val location: Location,
        @SerializedName("picture") val picture: Picture,
        @SerializedName("dob") val dob: Dob,
        var isAccepted: Boolean? = null
        //@SerializedName("registered") val registered: Registered,
        //@SerializedName("phone") val phone: String,
        //@SerializedName("cell") val cell: String,
        //@SerializedName("id") val id1: Id,
        //@SerializedName("nat") val nat: String
) : Parcelable