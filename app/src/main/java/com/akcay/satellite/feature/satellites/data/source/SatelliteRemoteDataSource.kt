package com.akcay.satellite.feature.satellites.data.source

import android.content.Context
import com.akcay.satellite.feature.satellites.data.entities.SatelliteListResponse
import com.akcay.satellite.feature.satellites.data.repository.SatelliteRepositoryImpl.Companion.SATELLITES
import com.akcay.satellite.util.CommonUtils
import com.akcay.satellite.util.Resource
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.hilt.android.qualifiers.ApplicationContext
import java.lang.reflect.Type
import javax.inject.Inject

class SatelliteRemoteDataSource @Inject constructor(
    @ApplicationContext private val context: Context,
    private val moshi: Moshi
) {

    suspend fun getSatelliteList(): Resource<List<SatelliteListResponse>> {
        val data = CommonUtils.loadJSONFromAsset(context, SATELLITES)
        val listMyData: Type = Types.newParameterizedType(
            MutableList::class.java,
            SatelliteListResponse::class.java
        )

        val adapter: JsonAdapter<List<SatelliteListResponse>> = moshi.adapter(listMyData)


        data?.let {
            return Resource.Success(adapter.fromJson(data)!!)
        }
        return Resource.Success(emptyList())
    }
}