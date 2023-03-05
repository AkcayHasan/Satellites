package com.akcay.satellite.ui.satellitedetail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.akcay.satellite.R
import com.akcay.satellite.base.BaseFragment
import com.akcay.satellite.databinding.FragmentSatelliteDetailBinding
import com.akcay.satellite.feature.satellites.domain.entities.SatelliteDetailModel
import com.akcay.satellite.util.Resource
import com.akcay.satellite.util.map
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SatelliteDetailFragment :
    BaseFragment<FragmentSatelliteDetailBinding, SatelliteDetailViewModel>(
        FragmentSatelliteDetailBinding::inflate
    ) {

    private val args: SatelliteDetailFragmentArgs by navArgs()

    override fun getViewModelClass(): Class<SatelliteDetailViewModel> =
        SatelliteDetailViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun initializeUi() {
        this.lifecycleScope.launchWhenCreated {
            viewModel.getSatelliteDetail()
            viewModel.getSatellitePositions()
        }
    }

    override fun observeViewModel() {
        this.lifecycleScope.launchWhenCreated {
            this.launch {
                viewModel.satelliteDetail.collect { resource ->
                    resource.map {
                        when (resource) {
                            Resource.Loading -> {
                                showLoadingBar()
                            }
                            is Resource.Success -> {
                                showListOfItems()
                                setAllTextViews(it)
                            }
                            is Resource.Error -> {

                            }
                        }
                    }
                }
            }
            this.launch {
                viewModel.satellitePositions.collect { resource ->
                    resource.map {
                        when (resource) {
                            Resource.Loading -> {
                                showLoadingBar()
                            }
                            is Resource.Success -> {
                                showListOfItems()
                                viewModel.updateLastPosition(it)
                            }
                            is Resource.Error -> {

                            }
                        }
                    }
                }
            }
            this.launch {
                viewModel.satelliteUpdatedPositions.collect {
                    binding.tvLastPosition.text = binding.root.context.getString(
                        R.string.text_view_satellite_last_position_values,
                        it.posX,
                        it.posY
                    )
                }
            }
        }
    }

    private fun setAllTextViews(satelliteDetailModel: SatelliteDetailModel?) {
        satelliteDetailModel?.let {
            binding.run {
                tvSatelliteName.text = args.name
                tvCost.text = it.costPerLaunch
                tvDate.text = it.firstFlight
                tvHeightOrMass.text = this.root.context.getString(
                    R.string.text_view_satellite_height_or_mass_values,
                    it.height,
                    it.mass
                )
            }
        }
    }

}