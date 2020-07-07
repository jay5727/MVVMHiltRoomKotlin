package com.jay.mvvmhiltkotlin.remote

import androidx.lifecycle.LiveData
import com.jay.mvvmhiltkotlin.model.user.PersonDetailsResponse
import com.jay.mvvmhiltkotlin.api.ApiResponse

import retrofit2.http.GET
import retrofit2.http.Query

interface PersonService {
  /**
   * Get the list of PersonDetailsResponse object.
   *
   * @param results Specify the page of results to query.
   *
   * @return [PersonDetailsResponse] response
   */
  @GET(".")
  fun fetchPersonList(@Query("results") results : Int): LiveData<ApiResponse<PersonDetailsResponse>>

}
