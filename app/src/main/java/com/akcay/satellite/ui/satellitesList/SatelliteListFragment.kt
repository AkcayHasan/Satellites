package com.akcay.satellite.ui.satellitesList

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.akcay.satellite.R
import com.akcay.satellite.base.BaseFragment
import com.akcay.satellite.databinding.FragmentSatelliteListBinding
import com.akcay.satellite.util.DividerItemDecorator
import com.akcay.satellite.util.Resource
import com.akcay.satellite.util.map
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SatelliteListFragment : BaseFragment<FragmentSatelliteListBinding, SatelliteListViewModel>(
    FragmentSatelliteListBinding::inflate
) {
    private val satelliteAdapter by lazy { SatelliteListAdapter() }
    override fun getViewModelClass(): Class<SatelliteListViewModel> =
        SatelliteListViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeUi()
    }

    private fun initializeUi() {
        this.lifecycleScope.launchWhenCreated {
            viewModel.getAllSatellitesList()
            viewModel.satelliteList.collect { resource ->
                resource.map {
                    when(resource) {
                        Resource.Loading -> {
                            showLoadingBar()
                        }
                        Resource.Error(IllegalArgumentException("asdasd")) -> {

                        }
                        Resource.Success(it) -> {
                            showListOfItems()
                            satelliteAdapter.differ.submitList(it)
                        }
                    }
                }
            }
        }
        satelliteAdapter.clickListener = { id ->
            Log.d("osman", "tıklandı = $id")
        }
        binding.rvSatellitesList.run {
            val rvLayoutManager =
                LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL, false)
            layoutManager = rvLayoutManager
            setHasFixedSize(true)
            ResourcesCompat.getDrawable(resources, R.drawable.divider, null)?.let {
                addItemDecoration(DividerItemDecorator(it))
            }
            adapter = satelliteAdapter
        }
    }
}