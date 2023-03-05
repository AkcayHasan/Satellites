package com.akcay.satellite.ui.satellitedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akcay.satellite.feature.satellites.domain.entities.PositionsEntityModel
import com.akcay.satellite.feature.satellites.domain.entities.SatelliteDetailModel
import com.akcay.satellite.feature.satellites.domain.usecase.SatelliteDetailUseCase
import com.akcay.satellite.feature.satellites.domain.usecase.SatellitePositionsUseCase
import com.akcay.satellite.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SatelliteDetailViewModel @Inject constructor(
    private val satelliteDetailUseCase: SatelliteDetailUseCase,
    private val satellitePositionsUseCase: SatellitePositionsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val satelliteId by lazy { savedStateHandle.get<Int>("id") }

    private val _satelliteDetail =
        MutableStateFlow<Resource<SatelliteDetailModel>>(Resource.Loading)
    val satelliteDetail: StateFlow<Resource<SatelliteDetailModel>>
        get() = _satelliteDetail

    private val _satellitePositions =
        MutableStateFlow<Resource<List<PositionsEntityModel>>>(Resource.Loading)
    val satellitePositions: StateFlow<Resource<List<PositionsEntityModel>>>
        get() = _satellitePositions

    private val _satelliteUpdatedPositions =
        MutableStateFlow(PositionsEntityModel("", ""))
    val satelliteUpdatedPositions: StateFlow<PositionsEntityModel>
        get() = _satelliteUpdatedPositions

    fun getSatelliteDetail() {
        viewModelScope.launch {
            try {
                satelliteId?.let { id ->
                    satelliteDetailUseCase.observe(id).collect {
                        _satelliteDetail.value = it
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getSatellitePositions() {
        viewModelScope.launch {
            try {
                satelliteId?.let { id ->
                    satellitePositionsUseCase.observe(id).collect {
                        _satellitePositions.value = it
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun updateLastPosition(positionsEntityModel: List<PositionsEntityModel>?) {
        viewModelScope.launch {
            positionsEntityModel?.let {
                for (i in it.indices) {
                    val posX = it[i].posX
                    val posY = it[i].posY
                    _satelliteUpdatedPositions.value = PositionsEntityModel(posX, posY)
                    delay(3000)
                }
            }
        }

    }
}