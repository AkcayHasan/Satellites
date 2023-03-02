package com.akcay.satellite.feature.satellites.data.entities

import com.squareup.moshi.Json

data class PositionsListResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "positions") val positions: List<Positions>
)
