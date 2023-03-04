package com.akcay.satellite.base

import com.akcay.satellite.util.Resource
import kotlinx.coroutines.flow.flow

open class BaseRepository {

    protected fun <T> fetch(apiCall: suspend () -> Resource<T>) = flow {
        emit(Resource.Loading)
        val response = apiCall.invoke()
        emit(response)
    }
}