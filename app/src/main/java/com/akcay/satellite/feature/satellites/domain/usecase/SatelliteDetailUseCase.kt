package com.akcay.satellite.feature.satellites.domain.usecase

import com.akcay.satellite.base.BaseUseCase
import com.akcay.satellite.feature.satellites.domain.entities.SatelliteDetailModel
import com.akcay.satellite.feature.satellites.domain.mapper.toSatelliteDetailModel
import com.akcay.satellite.feature.satellites.domain.repository.SatelliteRepository
import com.akcay.satellite.util.Resource
import com.akcay.satellite.util.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SatelliteDetailUseCase @Inject constructor(
    private val satelliteRepository: SatelliteRepository
) : BaseUseCase<Int, Resource<SatelliteDetailModel>>() {

    override suspend fun buildUseCase(params: Int): Flow<Resource<SatelliteDetailModel>> {
        return satelliteRepository.getSatelliteDetail(params)
            .map { satelliteDetailResponseResource ->
                satelliteDetailResponseResource.map { satelliteDetailResponse ->
                    satelliteDetailResponse?.toSatelliteDetailModel()
                }
            }
    }
}