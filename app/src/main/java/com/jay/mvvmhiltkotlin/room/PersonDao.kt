package com.jay.mvvmhiltkotlin.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jay.mvvmhiltkotlin.model.user.PersonDetail

/**
 *Data Access object Layer for operation related to Person Entity
 *Contains the methods used for accessing the database
 */
@Dao
interface PersonDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertPeople(people: List<PersonDetail>)

  @Query("UPDATE person SET isAccepted = :isAccepted WHERE email = :id_ ")
  suspend fun updatePerson(isAccepted: Boolean,id_: String ): Int

  @Query("SELECT * FROM person WHERE email = :id_")
  fun getPerson(id_: Int): PersonDetail

  @Query("SELECT * FROM person ")//WHERE page = :page_
  fun getPeople(): LiveData<List<PersonDetail>>
}
