package com.akcay.satellite.feature.satellites.data.source

import android.content.Context
import com.akcay.satellite.feature.satellites.data.entities.*
import com.akcay.satellite.util.Utilities
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.hilt.android.qualifiers.ApplicationContext
import java.lang.reflect.Type
import javax.inject.Inject

class SatelliteFileDataSource @Inject constructor(
    @ApplicationContext private val context: Context,
    private val moshi: Moshi
) {

    companion object {
        const val SATELLITES = "satellite-list"
        const val SATELLITE_DETAIL = "satellite-detail"
        const val SATELLITE_POSITIONS = "positions"
    }

    fun getSatelliteList(query: String?): List<SatelliteListResponse>? {
        val data = Utilities.loadJSONFromAsset(context, SATELLITES)
        val type: Type = Types.newParameterizedType(
            MutableList::class.java,
            SatelliteListResponse::class.java
        )

        val adapter: JsonAdapter<List<SatelliteListResponse>> = moshi.adapter(type)

        return data?.let {
            query?.let { searchText ->
                adapter.fromJson(it)?.filter { satelliteListResponse ->
                    satelliteListResponse.name.lowercase().contains(searchText)
                }?.apply {
                    this
                }
            } ?: kotlin.run {
                adapter.fromJson(it)
            }
        } ?: kotlin.run {
            null
        }
    }

    fun getSatelliteDetail(id: Int): SatelliteDetailResponse? {
        val data = Utilities.loadJSONFromAsset(context, SATELLITE_DETAIL)
        val type: Type = Types.newParameterizedType(
            MutableList::class.java,
            SatelliteDetailResponse::class.java
        )

        val adapter: JsonAdapter<List<SatelliteDetailResponse>> = moshi.adapter(type)

        return data?.let { details ->
            adapter.fromJson(details)?.find { it.id == id }.apply {
                this?.let {
                    return it
                }
            }
        } ?: kotlin.run {
            null
        }
    }

    fun getSatellitePosition(id: Int): List<PositionsEntity>? {
        val data = Utilities.loadJSONFromAsset(context, SATELLITE_POSITIONS)

        val adapter: JsonAdapter<PositionListResponse> =
            moshi.adapter(PositionListResponse::class.java)

        data?.let { positions ->
            adapter.fromJson(positions)?.let { positionListResponse ->
                positionListResponse.list.find { it.id == id }.apply {
                    this?.let {
                        return it.positions
                    }
                }
            }
        }
        return null
    }
}