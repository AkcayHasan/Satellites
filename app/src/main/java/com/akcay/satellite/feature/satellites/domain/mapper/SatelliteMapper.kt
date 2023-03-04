package com.akcay.satellite.feature.satellites.domain.mapper

import com.akcay.satellite.feature.satellites.data.entities.SatelliteDetailResponse
import com.akcay.satellite.feature.satellites.data.entities.SatelliteListResponse
import com.akcay.satellite.feature.satellites.domain.entities.SatelliteDetailModel
import com.akcay.satellite.feature.satellites.domain.entities.SatelliteListModel

fun SatelliteListResponse.toSatellitesListModel() = SatelliteListModel(
    id, active, name
)

fun SatelliteDetailResponse.toSatelliteDetailModel() = SatelliteDetailModel(
    id, costPerLaunch.toString(), firstFlight, height.toString(), mass.toString()
)