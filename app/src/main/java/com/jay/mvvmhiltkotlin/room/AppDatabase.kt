package com.jay.mvvmhiltkotlin.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jay.mvvmhiltkotlin.model.user.PersonDetail

/**
 * AppDatabase class to handle CRUD related operations
 * Include the list of entities associated with the database within the annotation.
 * Contains Abstract DAO methods
 */
@Database(entities = [PersonDetail::class], version = 1)
@TypeConverters(PersonListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getPerson(): PersonDao

    companion object {
        const val DATABASE_NAME = "Person.db"
    }

}