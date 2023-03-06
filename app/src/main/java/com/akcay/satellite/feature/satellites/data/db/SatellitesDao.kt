package com.akcay.satellite.feature.satellites.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.akcay.satellite.feature.satellites.domain.entities.SatelliteDetailModel

@Dao
interface SatellitesDao {

    @Insert
    suspend fun addSatelliteDetail(satelliteDetailModel: SatelliteDetailModel)

    @Query("SELECT * FROM satellite_detail WHERE id = :satelliteId")
    suspend fun getSatelliteDetail(satelliteId: Int): SatelliteDetailModel
}