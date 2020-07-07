package com.jay.mvvmhiltkotlin.model.user

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class Street (
		@SerializedName("number") val number : Int,
		@SerializedName("name") val name : String
) : Parcelable