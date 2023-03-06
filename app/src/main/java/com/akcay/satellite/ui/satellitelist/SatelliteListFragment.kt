package com.akcay.satellite.ui.satellitelist

import android.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
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

    override fun observeViewModel() {
        this.lifecycleScope.launchWhenCreated {
            viewModel.satelliteList.collect { resource ->
                resource.map {
                    when (resource) {
                        Resource.Loading -> {
                            showLoadingBar()
                        }
                        is Resource.Success -> {
                            showListOfItems()
                            satelliteAdapter.differ.submitList(it)
                        }
                        is Resource.Error -> {

                        }
                    }
                }
            }
        }
    }

    override fun initializeUi() {
        this.lifecycleScope.launchWhenCreated {
            viewModel.getRelatedSatelliteList()
        }
        binding.run {
            rvSatellitesList.run {
                layoutManager =
                    LinearLayoutManager(binding.root.context, LinearLayoutManager.VERTICAL, false)
                setHasFixedSize(true)
                ResourcesCompat.getDrawable(resources, R.drawable.divider, null)?.let {
                    addItemDecoration(DividerItemDecorator(it))
                }
                adapter = satelliteAdapter.also {
                    it.clickListener = { name, id ->
                        SatelliteListFragmentDirections.actionSatellitesListFragmentToSatelliteDetailFragment(
                            name,
                            id
                        ).also(
                            findNavController()::navigate
                        )
                    }
                }
            }
            searchView.run {
                setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return false
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        viewModel.searchSatellites(newText)
                        return true
                    }
                })
            }
        }
    }
}