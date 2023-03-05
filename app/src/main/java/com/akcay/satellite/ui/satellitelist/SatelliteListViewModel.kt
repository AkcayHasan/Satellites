package com.akcay.satellite.ui.satellitelist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.akcay.satellite.base.None
import com.akcay.satellite.feature.satellites.domain.entities.SatelliteListModel
import com.akcay.satellite.feature.satellites.domain.usecase.SatelliteListUseCase
import com.akcay.satellite.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SatelliteListViewModel @Inject constructor(
    private val satelliteListUseCase: SatelliteListUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var job: Job? = null

    private val _satelliteList =
        MutableStateFlow<Resource<List<SatelliteListModel>>>(Resource.Loading)
    val satelliteList: StateFlow<Resource<List<SatelliteListModel>>>
        get() = _satelliteList

    fun getAllSatellitesList() {
        viewModelScope.launch {
            try {
                satelliteListUseCase.observe(None).collect {
                    _satelliteList.value = it
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun searchSatellites(text: String?) {
        viewModelScope.launch {
            job?.cancel()
            job = viewModelScope.launch {
                delay(1000)
                text?.let {
                    if (it.isNotBlank()) {

                    } else {
                        getAllSatellitesList()
                    }
                }
            }
        }
    }
}