package com.akcay.satellite.feature.satellites.data.entities

import com.squareup.moshi.Json


data class SatelliteListResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "active") val active: Boolean,
    @Json(name = "name") val name: String
)
