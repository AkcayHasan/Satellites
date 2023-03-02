package com.akcay.satellite.feature.satellites.domain.repository

import com.akcay.satellite.feature.satellites.data.entities.Positions
import com.akcay.satellite.feature.satellites.data.entities.SatelliteDetailResponse
import com.akcay.satellite.feature.satellites.data.entities.SatellitesListResponse

interface SatelliteRepository {

    suspend fun getSatellites(): List<SatellitesListResponse>
    suspend fun getSatelliteDetail(id: Int): SatelliteDetailResponse?
    suspend fun getSatellitePosition(id: Int): Positions?
    suspend fun searchSatellites(query: String): List<SatellitesListResponse>
}