package com.jay.mvvmhiltkotlin.mapper

import com.jay.mvvmhiltkotlin.api.NetworkResponseMapper
import com.jay.mvvmhiltkotlin.model.user.PersonDetailsResponse

class PersonResponseMapper : NetworkResponseMapper<PersonDetailsResponse> {
    override fun onLastPage(response: PersonDetailsResponse): Boolean {
        return true
        //response.page > 10//assuming minimum 100 records exist(10*10)
    }
}