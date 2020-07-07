package com.jay.mvvmhiltkotlin.repository

import androidx.lifecycle.LiveData
import com.jay.mvvmhiltkotlin.api.ApiResponse
import com.jay.mvvmhiltkotlin.api.NetworkBoundResource
import com.jay.mvvmhiltkotlin.api.Resource
import com.jay.mvvmhiltkotlin.mapper.PersonResponseMapper
import com.jay.mvvmhiltkotlin.model.user.PersonDetail
import com.jay.mvvmhiltkotlin.model.user.PersonDetailsResponse
import com.jay.mvvmhiltkotlin.remote.PersonService
import com.jay.mvvmhiltkotlin.room.PersonDao
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/***
 * Created by Jay on 04/07/2020
 */
@Singleton
/**
 * @param personService person service api implementation
 * @param personDao DAO object to perform DB operations
 */
class PersonRepository @Inject constructor(
        private val personService: PersonService,
        private val personDao: PersonDao
) : Repository {

    init {
        Timber.d("Injection PeopleRepository")
    }

    fun loadPeople(page: Int): LiveData<Resource<List<PersonDetail>>> {
        return object : NetworkBoundResource<List<PersonDetail>, PersonDetailsResponse, PersonResponseMapper>() {

            override fun saveFetchData(items: PersonDetailsResponse) {
                for (item in items.results) {
                    item.page = page
                }
                personDao.insertPeople(items.results)
            }

            override fun shouldFetch(data: List<PersonDetail>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb(): LiveData<List<PersonDetail>> {
                return personDao.getPeople()
            }

            override fun fetchService(): LiveData<ApiResponse<PersonDetailsResponse>> {
                return personService.fetchPersonList(results = 10)
            }

            override fun mapper(): PersonResponseMapper {
                return PersonResponseMapper()
            }

            override fun onFetchFailed(message: String?) {
                Timber.d("onFetchFailed : $message")
            }
        }.asLiveData()
    }

    suspend fun updatePerson(personDetail: PersonDetail) {
        personDao.updatePerson(personDetail.isAccepted ?: false, personDetail.email)
    }

}
