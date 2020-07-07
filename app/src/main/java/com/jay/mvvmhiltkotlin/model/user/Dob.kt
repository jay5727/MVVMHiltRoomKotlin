package com.jay.mvvmhiltkotlin.model.user

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class Dob(
        @SerializedName("date") val date: String,
        @SerializedName("age") val age: String//java.lang.NumberFormatException: For input string: "C1T 9K8"
): Parcelable