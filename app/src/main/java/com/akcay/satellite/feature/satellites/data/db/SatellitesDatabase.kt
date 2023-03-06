package com.akcay.satellite.feature.satellites.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.akcay.satellite.feature.satellites.domain.entities.SatelliteDetailModel

@Database(entities = [SatelliteDetailModel::class], version = 1, exportSchema = false)
abstract class SatellitesDatabase : RoomDatabase() {

    abstract fun satellitesDao(): SatellitesDao
}