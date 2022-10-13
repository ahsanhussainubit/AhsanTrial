package com.example.ahsantrial.data.utils

data class Resource<T>(val status: STATUS, val data: T?, val error: Throwable?) {

    companion object {
        fun <T> success(data: T) =
            Resource(STATUS.SUCCESS, data, null)

        fun error(error: Throwable) =
            Resource(STATUS.ERROR, null, error)
    }


    enum class STATUS {
        SUCCESS,
        ERROR
    }

}