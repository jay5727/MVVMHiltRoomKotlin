package com.jay.mvvmhiltkotlin.utils.extensions

import android.view.View
import com.jay.mvvmhiltkotlin.api.Resource

inline fun <reified T> View.bindResource(resource: Resource<T>?, onSuccess: (Resource<T>) -> Unit) {
  if (resource != null) {
    when (resource.status) {
      Resource.Status.LOADING -> Unit
      Resource.Status.SUCCESS -> onSuccess(resource)
      Resource.Status.ERROR ->{}
        //Toast.makeText(context, resource.errorEnvelope?.status_message.toString(), Toast.LENGTH_SHORT).show()
    }
  }
}
