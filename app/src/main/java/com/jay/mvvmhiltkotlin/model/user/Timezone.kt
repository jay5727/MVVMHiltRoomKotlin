package com.jay.mvvmhiltkotlin.model.user

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class Timezone (
	@SerializedName("offset") val offset : String,
	@SerializedName("description") val description : String
) : Parcelable