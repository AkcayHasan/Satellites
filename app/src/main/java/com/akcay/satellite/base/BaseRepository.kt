package com.akcay.satellite.base

import com.akcay.satellite.util.Resource
import com.akcay.satellite.util.map
import kotlinx.coroutines.flow.flow

open class BaseRepository {

    protected fun <T> fetch(fileCall: suspend () -> T?) = flow {
        emit(Resource.Loading)
        val response = fileCall.invoke()
        response?.let {
            emit(Resource.Success(it))
        } ?: kotlin.run {
            emit(Resource.Error(Exception("An Error Occurred!")))
        }
    }
}