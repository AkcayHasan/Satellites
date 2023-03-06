package com.akcay.satellite.feature.satellites.data.repository

import com.akcay.satellite.base.BaseRepository
import com.akcay.satellite.feature.satellites.data.source.SatelliteLocalDataSource
import com.akcay.satellite.feature.satellites.data.source.SatelliteFileDataSource
import com.akcay.satellite.feature.satellites.domain.repository.SatelliteRepository

class SatelliteRepositoryImpl(
    private val fileDataSource: SatelliteFileDataSource,
    private val localDataSource: SatelliteLocalDataSource
) : BaseRepository(), SatelliteRepository {

    override suspend fun getSatellites(query: String?) = fetch {
        fileDataSource.getSatelliteList(query)
    }

    override suspend fun getSatelliteDetail(id: Int) = fetch {
        fileDataSource.getSatelliteDetail(id)
    }

    override suspend fun getSatellitePosition(id: Int) = fetch {
        fileDataSource.getSatellitePosition(id)
    }

}