package com.jay.mvvmhiltkotlin.model.user

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class Info(
        @SerializedName("seed") val seed: String,
        @SerializedName("results") val results: Int,
        @SerializedName("page") val page: Int,
        @SerializedName("version") val version: Double
): Parcelable