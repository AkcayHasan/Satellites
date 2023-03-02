package com.akcay.satellite.feature.satellites.domain.entities

import com.akcay.satellite.base.BaseModel

data class SatellitesListModel(
    val id: Int,
    val active: Boolean,
    val name: String
): BaseModel()
