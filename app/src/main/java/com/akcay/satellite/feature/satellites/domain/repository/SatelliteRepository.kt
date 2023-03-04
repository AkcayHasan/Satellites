package com.akcay.satellite.feature.satellites.domain.repository

import com.akcay.satellite.feature.satellites.data.entities.Positions
import com.akcay.satellite.feature.satellites.data.entities.SatelliteDetailResponse
import com.akcay.satellite.feature.satellites.data.entities.SatelliteListResponse
import com.akcay.satellite.util.Resource
import kotlinx.coroutines.flow.Flow

interface SatelliteRepository {

    fun getSatellites(): Flow<Resource<List<SatelliteListResponse>>>
    suspend fun getSatelliteDetail(id: Int): SatelliteDetailResponse?
    suspend fun getSatellitePosition(id: Int): Positions?
    suspend fun searchSatellites(query: String): List<SatelliteListResponse>
}