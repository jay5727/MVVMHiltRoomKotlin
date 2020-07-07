package com.jay.mvvmhiltkotlin.api

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 *
 */
data class Resource<out T>(val status: Status, val data: T? = null, val message: String? = null,
                           val onLastPage: Boolean) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    val isSuccess: Boolean
        get() = status == Status.SUCCESS && data != null

    val isLoading: Boolean
        get() = status == Status.LOADING

    val isLoaded: Boolean
        get() = status != Status.LOADING

    companion object {

        /**
         * Creates [Resource] object with `SUCCESS` status and [data].
         */
        fun <T> success(data: T?): Resource<T> {
            return Resource(status = Status.SUCCESS, data = data, message = null, onLastPage = false)
        }

        /**
         * Creates [Resource] object with `ERROR` status and [message].
         */
        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(status = Status.ERROR, data = data, message = msg, onLastPage = true)
        }

        /**
         * Creates [Resource] object with `LOADING` status to notify
         * the UI to showing loading.
         */
        fun <T> loading(data: T?): Resource<T> {
            return Resource(status = Status.LOADING, data = data, message = null, onLastPage = false)
        }
    }
}