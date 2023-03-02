package com.akcay.satellite.feature.satellites.data.repository

import com.akcay.satellite.feature.satellites.data.entities.Positions
import com.akcay.satellite.feature.satellites.data.entities.SatelliteDetailResponse
import com.akcay.satellite.feature.satellites.data.entities.SatellitesListResponse
import com.akcay.satellite.feature.satellites.domain.repository.SatelliteRepository

class SatelliteRepositoryImpl: SatelliteRepository {

    override suspend fun getSatellites(): List<SatellitesListResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getSatelliteDetail(id: Int): SatelliteDetailResponse? {
        TODO("Not yet implemented")
    }

    override suspend fun getSatellitePosition(id: Int): Positions? {
        TODO("Not yet implemented")
    }

    override suspend fun searchSatellites(query: String): List<SatellitesListResponse> {
        TODO("Not yet implemented")
    }
}