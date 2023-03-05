package com.akcay.satellite.feature.satellites.data.entities

import com.squareup.moshi.Json

data class PositionListResponse(
    @Json(name = "list") val list: List<PositionListEntity>
)
