package com.akcay.satellite.feature.satellites.domain.usecase

import com.akcay.satellite.base.BaseUseCase
import com.akcay.satellite.feature.satellites.data.entities.PositionListResponse
import com.akcay.satellite.feature.satellites.domain.entities.PositionListModel
import com.akcay.satellite.feature.satellites.domain.entities.PositionsEntityModel
import com.akcay.satellite.feature.satellites.domain.mapper.toPositions
import com.akcay.satellite.feature.satellites.domain.mapper.toPositionsEntityModel
import com.akcay.satellite.feature.satellites.domain.repository.SatelliteRepository
import com.akcay.satellite.util.Resource
import com.akcay.satellite.util.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SatellitePositionsUseCase @Inject constructor(
    private val satelliteRepository: SatelliteRepository
) : BaseUseCase<Int, Resource<List<PositionsEntityModel>>>() {

    override suspend fun buildUseCase(params: Int): Flow<Resource<List<PositionsEntityModel>>> {
        return satelliteRepository.getSatellitePosition(params).map { positionsEntityResource ->
            positionsEntityResource.map { positionsEntities ->
                positionsEntities?.let {
                    it.map { entity ->
                        entity.toPositionsEntityModel()
                    }
                }
            }
        }
    }
}