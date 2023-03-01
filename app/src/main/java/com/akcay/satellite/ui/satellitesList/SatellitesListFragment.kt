package com.akcay.satellite.ui.satellitesList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akcay.satellite.R
import com.akcay.satellite.base.BaseFragment
import com.akcay.satellite.databinding.FragmentSatellitesListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SatellitesListFragment : BaseFragment<FragmentSatellitesListBinding, SatellitesListViewModel>(
    FragmentSatellitesListBinding::inflate
) {
    override fun getViewModelClass(): Class<SatellitesListViewModel> =
        SatellitesListViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.root
    }
}