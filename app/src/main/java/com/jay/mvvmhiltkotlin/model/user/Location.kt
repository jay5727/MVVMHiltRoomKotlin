package com.jay.mvvmhiltkotlin.model.user

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class Location (
		@SerializedName("city") val city : String,
		@SerializedName("state") val state : String,
		@SerializedName("country") val country : String,
		@SerializedName("postcode") val postcode : String//java.lang.NumberFormatException: For input string: "O7V 3H1"
		//@SerializedName("street") val street : Street,
		//@SerializedName("coordinates") val coordinates : Coordinates,
		//@SerializedName("timezone") val timezone : Timezone
): Parcelable