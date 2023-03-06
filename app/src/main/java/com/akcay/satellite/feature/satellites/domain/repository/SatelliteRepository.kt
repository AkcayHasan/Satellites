package com.akcay.satellite.feature.satellites.domain.repository

import com.akcay.satellite.feature.satellites.data.entities.PositionsEntity
import com.akcay.satellite.feature.satellites.data.entities.SatelliteDetailResponse
import com.akcay.satellite.feature.satellites.data.entities.SatelliteListResponse
import com.akcay.satellite.util.Resource
import kotlinx.coroutines.flow.Flow

interface SatelliteRepository {

    suspend fun getSatellites(query: String?): Flow<Resource<List<SatelliteListResponse>>>
    suspend fun getSatelliteDetail(id: Int): Flow<Resource<SatelliteDetailResponse>>
    suspend fun getSatellitePosition(id: Int): Flow<Resource<List<PositionsEntity>>>
}