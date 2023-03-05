package com.akcay.satellite.feature.satellites.domain.mapper

import com.akcay.satellite.feature.satellites.data.entities.*
import com.akcay.satellite.feature.satellites.domain.entities.*

fun SatelliteListResponse.toSatellitesListModel() = SatelliteListModel(
    id, active, name
)

fun SatelliteDetailResponse.toSatelliteDetailModel() = SatelliteDetailModel(
    id, costPerLaunch.toString(), firstFlight, height.toString(), mass.toString()
)

fun PositionListResponse.toPositions() = PositionListModel(
    list.map {
        it.toPositionListEntityModel()
    }
)

fun PositionListEntity.toPositionListEntityModel() = PositionListEntityModel(
    id, positions.map { it.toPositionsEntityModel() }
)

fun PositionsEntity.toPositionsEntityModel() = PositionsEntityModel(
    posX.toString(), posY.toString()
)