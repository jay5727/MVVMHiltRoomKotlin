package com.jay.mvvmhiltkotlin.model.user

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class Picture (
	@SerializedName("large") val large : String,
	@SerializedName("medium") val medium : String,
	@SerializedName("thumbnail") val thumbnail : String
) : Parcelable