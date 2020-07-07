package com.jay.mvvmhiltkotlin.model.user

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class Name (
	@SerializedName("title") val title : String,
	@SerializedName("first") val first : String,
	@SerializedName("last") val last : String
): Parcelable