package com.akcay.satellite.module

import com.akcay.satellite.feature.satellites.data.repository.SatelliteRepositoryImpl
import com.akcay.satellite.feature.satellites.data.source.SatelliteLocalDataSource
import com.akcay.satellite.feature.satellites.data.source.SatelliteFileDataSource
import com.akcay.satellite.feature.satellites.domain.repository.SatelliteRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SatelliteModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun provideSatelliteRepository(
        remoteDataSource: SatelliteFileDataSource,
        localDataSource: SatelliteLocalDataSource
    ): SatelliteRepository = SatelliteRepositoryImpl(remoteDataSource, localDataSource)


}