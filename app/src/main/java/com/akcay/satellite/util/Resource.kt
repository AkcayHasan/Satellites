package com.akcay.satellite.util

sealed class Resource<out T> {
    data class Success<out T>(val data: T?) : Resource<T>()
    data class Error(val exception: Exception) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}

fun <T, R> Resource<T>.map(action: (T?) -> R?): Resource<R> {
    return when(this) {
        is Resource.Success -> Resource.Success(action.invoke(data))
        is Resource.Loading -> Resource.Loading
        is Resource.Error -> Resource.Error(exception)
    }
}