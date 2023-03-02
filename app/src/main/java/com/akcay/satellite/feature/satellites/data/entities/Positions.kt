package com.akcay.satellite.feature.satellites.data.entities

import com.squareup.moshi.Json

data class Positions(
    @Json(name = "posX") val posX: Double,
    @Json(name = "posY") val posY: Double
)
