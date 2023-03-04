package com.akcay.satellite.feature.satellites.domain.entities

data class SatelliteDetailModel(
    val id: Int,
    val costPerLaunch: String,
    val firstFlight: String,
    val height: String,
    val mass: String
)
