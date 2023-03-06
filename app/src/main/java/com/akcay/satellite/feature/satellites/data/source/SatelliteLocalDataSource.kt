package com.akcay.satellite.feature.satellites.data.source

import com.akcay.satellite.feature.satellites.data.db.SatellitesDatabase
import com.akcay.satellite.feature.satellites.data.entities.SatelliteDetailResponse
import com.akcay.satellite.feature.satellites.domain.entities.SatelliteDetailModel
import com.akcay.satellite.util.Resource
import javax.inject.Inject

class SatelliteLocalDataSource @Inject constructor(
    private val satellitesDatabase: SatellitesDatabase
) {

    /*suspend fun getSatelliteDetailFromDb(satelliteId: Int): SatelliteDetailModel {
        satellitesDatabase.satellitesDao().getSatelliteDetail(satelliteId)
    }*/
}