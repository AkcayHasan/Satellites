package com.akcay.satellite.feature.satellites.data.repository

import com.akcay.satellite.base.BaseRepository
import com.akcay.satellite.feature.satellites.data.entities.SatelliteListResponse
import com.akcay.satellite.feature.satellites.data.source.SatelliteLocalDataSource
import com.akcay.satellite.feature.satellites.data.source.SatelliteFileDataSource
import com.akcay.satellite.feature.satellites.domain.repository.SatelliteRepository
import com.akcay.satellite.util.Resource
import kotlinx.coroutines.flow.Flow

class SatelliteRepositoryImpl(
    private val fileDataSource: SatelliteFileDataSource,
    private val localDataSource: SatelliteLocalDataSource
) : BaseRepository(), SatelliteRepository {

    override suspend fun getSatellites() = fetch {
        fileDataSource.getSatelliteList()
    }

    override suspend fun getSatelliteDetail(id: Int) = fetch {
        fileDataSource.getSatelliteDetail(id)
    }

    override suspend fun getSatellitePosition(id: Int) = fetch {
        fileDataSource.getSatellitePosition(id)
    }


    override suspend fun searchSatellites(query: String): Flow<Resource<List<SatelliteListResponse>>> {
        TODO("Not yet implemented")
    }

}