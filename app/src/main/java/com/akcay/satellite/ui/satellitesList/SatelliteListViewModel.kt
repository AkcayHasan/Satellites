package com.akcay.satellite.ui.satellitesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akcay.satellite.base.None
import com.akcay.satellite.feature.satellites.domain.entities.SatelliteListModel
import com.akcay.satellite.feature.satellites.domain.usecase.SatelliteUseCase
import com.akcay.satellite.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SatelliteListViewModel @Inject constructor(
    private val satelliteUseCase: SatelliteUseCase
) : ViewModel() {

    private val _satelliteList =
        MutableStateFlow<Resource<List<SatelliteListModel>>>(Resource.Loading)
    val satelliteList: StateFlow<Resource<List<SatelliteListModel>>>
        get() = _satelliteList

    fun getAllSatellitesList() {
        viewModelScope.launch {
            satelliteUseCase.observe(None).collect {
                _satelliteList.value = it
            }
        }
    }
}