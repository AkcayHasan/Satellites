package com.akcay.satellite.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseViewModel: ViewModel() {

    private val loading = MutableStateFlow(false)
}