package com.akcay.satellite.feature.satellites.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "satellite_detail")
data class SatelliteDetailModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val costPerLaunch: String,
    val firstFlight: String,
    val height: String,
    val mass: String
)
