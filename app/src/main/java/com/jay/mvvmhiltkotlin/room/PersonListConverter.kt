package com.jay.mvvmhiltkotlin.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jay.mvvmhiltkotlin.model.user.*

/**
 * Convertor class for custom types.
 * Since room knows handling Primitive Types only....
 */
open class PersonListConverter {

    @TypeConverter
    fun fromPersonString(value: String): List<PersonDetail>? {
        val listType = object : TypeToken<List<PersonDetail>>() {}.type
        return Gson().fromJson<List<PersonDetail>>(value, listType)
    }

    @TypeConverter
    fun fromPersonList(list: List<PersonDetail>?): String {
        return Gson().toJson(list)
    }

    //Login
    @TypeConverter
    fun fromLoginString(value: String): Login? {
        return Gson().fromJson(value, Login::class.java)
    }

    @TypeConverter
    fun fromLoginObject(list: Login?): String {
        return Gson().toJson(list)
    }

    //Name
    @TypeConverter
    fun fromNameString(value: String): Name? {
        return Gson().fromJson(value, Name::class.java)
    }

    @TypeConverter
    fun fromNameObject(name: Name?): String {
        return Gson().toJson(name)
    }

    //Profile
    @TypeConverter
    fun fromProfileString(value: String): Picture? {
        return Gson().fromJson(value, Picture::class.java)
    }

    @TypeConverter
    fun fromProfileObject(picture: Picture?): String {
        return Gson().toJson(picture)
    }

    //Location
    @TypeConverter
    fun fromLocationString(value: String): Location? {
        return Gson().fromJson(value, Location::class.java)
    }

    @TypeConverter
    fun fromLocationObject(location: Location?): String {
        return Gson().toJson(location)
    }

    //DOB
    @TypeConverter
    fun fromDobString(value: String): Dob? {
        return Gson().fromJson(value, Dob::class.java)
    }

    @TypeConverter
    fun fromDobObject(dob: Dob?): String {
        return Gson().toJson(dob)
    }
}
