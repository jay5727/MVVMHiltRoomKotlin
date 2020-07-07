package com.jay.mvvmhiltkotlin.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.jay.mvvmhiltkotlin.api.AbsentLiveData
import com.jay.mvvmhiltkotlin.api.Resource
import com.jay.mvvmhiltkotlin.model.user.PersonDetail
import com.jay.mvvmhiltkotlin.repository.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

/***
 * Created by Jay on 04/07/2020
 */

/**
 *@param repository Person Repository
 */
class PersonDetailViewModel @ViewModelInject constructor(
        private val repository: PersonRepository
) : ViewModel() {

    private var peoplePageLiveData: MutableLiveData<Int> = MutableLiveData()
    val peopleLiveData: LiveData<Resource<List<PersonDetail>>>

    init {
        Timber.d("Injection : PersonDetailViewModel")

        peopleLiveData = peoplePageLiveData.switchMap {
            peoplePageLiveData.value?.let { repository.loadPeople(it) }
                    ?: AbsentLiveData.create()
        }
    }

    fun getPeopleValues() = peopleLiveData.value

    fun postPeoplePage(page: Int) = peoplePageLiveData.postValue(page)

    /**
     * @param personDetail object to update in daabase
     */
    fun updatePerson(personDetail: PersonDetail) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePerson(personDetail)
        }
    }
}
