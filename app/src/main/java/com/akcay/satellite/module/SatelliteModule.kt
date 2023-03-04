package com.akcay.satellite.module

import android.content.Context
import com.akcay.satellite.feature.satellites.data.repository.SatelliteRepositoryImpl
import com.akcay.satellite.feature.satellites.data.source.SatelliteLocalDataSource
import com.akcay.satellite.feature.satellites.data.source.SatelliteRemoteDataSource
import com.akcay.satellite.feature.satellites.domain.repository.SatelliteRepository
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
        remoteDataSource: SatelliteRemoteDataSource,
        localDataSource: SatelliteLocalDataSource
    ): SatelliteRepository = SatelliteRepositoryImpl(remoteDataSource, localDataSource)


}