package com.akcay.satellite.feature.satellites.domain.usecase

import com.akcay.satellite.base.BaseUseCase
import com.akcay.satellite.feature.satellites.domain.entities.SatelliteListModel
import com.akcay.satellite.feature.satellites.domain.mapper.toSatellitesListModel
import com.akcay.satellite.feature.satellites.domain.repository.SatelliteRepository
import com.akcay.satellite.util.Resource
import com.akcay.satellite.util.map
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class SatelliteListUseCase @Inject constructor(
    private val satelliteRepository: SatelliteRepository
): BaseUseCase<String?, Resource<List<SatelliteListModel>>>() {

    override suspend fun buildUseCase(params: String?): Flow<Resource<List<SatelliteListModel>>> {
        return satelliteRepository.getSatellites(params).map { satelliteListResponseResource ->
            satelliteListResponseResource.map { satelliteListResponses ->
                satelliteListResponses?.let {listResponses ->
                    listResponses.map {
                        it.toSatellitesListModel()
                    }
                }
            }
        }
    }

}