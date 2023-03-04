package com.akcay.satellite.feature.satellites.data.repository

import android.content.Context
import com.akcay.satellite.base.BaseRepository
import com.akcay.satellite.feature.satellites.data.entities.Positions
import com.akcay.satellite.feature.satellites.data.entities.SatelliteDetailResponse
import com.akcay.satellite.feature.satellites.data.entities.SatelliteListResponse
import com.akcay.satellite.feature.satellites.data.source.SatelliteLocalDataSource
import com.akcay.satellite.feature.satellites.data.source.SatelliteRemoteDataSource
import com.akcay.satellite.feature.satellites.domain.repository.SatelliteRepository

class SatelliteRepositoryImpl(
    private val remoteDataSource: SatelliteRemoteDataSource,
    private val localDataSource: SatelliteLocalDataSource
) : BaseRepository(), SatelliteRepository {

    companion object {
        const val SATELLITES = "satellite-list"
    }

    override fun getSatellites() = fetch {
        remoteDataSource.getSatelliteList()
    }

    override suspend fun getSatelliteDetail(id: Int): SatelliteDetailResponse? {
        TODO("Not yet implemented")
    }

    override suspend fun getSatellitePosition(id: Int): Positions? {
        TODO("Not yet implemented")
    }

    override suspend fun searchSatellites(query: String): List<SatelliteListResponse> {
        TODO("Not yet implemented")
    }
}

/*
import android.content.Context
import com.akcay.satellite.base.BaseRepository
import com.akcay.satellite.feature.satellites.data.entities.Positions
import com.akcay.satellite.feature.satellites.data.entities.SatelliteDetailResponse
import com.akcay.satellite.feature.satellites.data.entities.SatelliteListResponse
import com.akcay.satellite.feature.satellites.data.source.SatelliteLocalDataSource
import com.akcay.satellite.feature.satellites.data.source.SatelliteRemoteDataSource
import com.akcay.satellite.feature.satellites.domain.repository.SatelliteRepository
import com.akcay.satellite.util.CommonUtils
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import java.lang.reflect.Type


val data = CommonUtils.loadJSONFromAsset(context, SATELLITES)
        val listMyData: Type = com.squareup.moshi.Types.newParameterizedType(
            MutableList::class.java,
            SatelliteListResponse::class.java
        )

        val adapter: JsonAdapter<List<SatelliteListResponse>> = moshi.adapter<List<SatelliteListResponse>>(listMyData)


        data?.let {
            return adapter.fromJson(data)!!
        }
        return emptyList()
 */