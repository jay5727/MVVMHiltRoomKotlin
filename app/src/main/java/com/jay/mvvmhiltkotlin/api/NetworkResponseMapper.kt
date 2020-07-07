package com.jay.mvvmhiltkotlin.api

import com.jay.mvvmhiltkotlin.model.NetworkResponseModel

interface NetworkResponseMapper<in FROM : NetworkResponseModel> {
  fun onLastPage(response: FROM): Boolean
}
