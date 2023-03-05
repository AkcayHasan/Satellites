package com.akcay.satellite.feature.satellites.data.entities

import com.squareup.moshi.Json

data class PositionListEntity(
    @Json(name = "id") val id: Int,
    @Json(name = "positions") val positions: List<PositionsEntity>
)
