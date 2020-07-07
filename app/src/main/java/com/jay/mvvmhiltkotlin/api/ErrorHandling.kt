package com.jay.mvvmhiltkotlin.api

class ErrorHandling {

    companion object{

        private val TAG: String = "AppDebug"

        const val UNABLE_TO_RESOLVE_HOST = "Unable to resolve host"
        const val GENERIC_ERROR = "Something Went Wrong"
        const val ERROR_CHECK_NETWORK_CONNECTION = "Check network connection."
        const val NO_DATA = "No Data Found."

        fun isNetworkError(msg: String): Boolean{
            when{
                msg.contains(UNABLE_TO_RESOLVE_HOST) -> return true
                else-> return false
            }
        }
    }
}