package com.akcay.satellite.feature.satellites.data.entities

import com.squareup.moshi.Json

data class SatelliteDetailResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "cost_per_launch") val costPerLaunch: Int,
    @Json(name = "first_flight") val firstFlight: String,
    @Json(name = "height") val height: Int,
    @Json(name = "mass") val mass: Int
)
