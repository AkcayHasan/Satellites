package com.akcay.satellite.feature.satellites.data.entities

import com.squareup.moshi.Json

data class PositionsResponse(
    @Json(name = "list") val list: List<PositionsListResponse>
)
