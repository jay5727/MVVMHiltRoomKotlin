package com.jay.mvvmhiltkotlin.model.user

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class Login (
		@SerializedName("uuid") val uuid : String,
		@SerializedName("username") val username : String,
		@SerializedName("password") val password : String,
		@SerializedName("salt") val salt : String,
		@SerializedName("md5") val md5 : String,
		@SerializedName("sha1") val sha1 : String,
		@SerializedName("sha256") val sha256 : String
) : Parcelable