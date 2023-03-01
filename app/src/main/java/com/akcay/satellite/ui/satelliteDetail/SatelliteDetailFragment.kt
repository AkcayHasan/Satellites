package com.akcay.satellite.ui.satelliteDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akcay.satellite.R
import com.akcay.satellite.base.BaseFragment
import com.akcay.satellite.databinding.FragmentSatelliteDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SatelliteDetailFragment :
    BaseFragment<FragmentSatelliteDetailBinding, SatelliteDetailViewModel>(
        FragmentSatelliteDetailBinding::inflate
    ) {
    override fun getViewModelClass(): Class<SatelliteDetailViewModel> =
        SatelliteDetailViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}