package com.jay.mvvmhiltkotlin.model.user

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class Coordinates(
        @SerializedName("latitude") val latitude: Double,
        @SerializedName("longitude") val longitude: Double
): Parcelable