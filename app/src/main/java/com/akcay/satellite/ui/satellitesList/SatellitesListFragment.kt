package com.akcay.satellite.ui.satellitesList

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.akcay.satellite.R
import com.akcay.satellite.base.BaseFragment
import com.akcay.satellite.databinding.FragmentSatellitesListBinding
import com.akcay.satellite.feature.satellites.domain.entities.SatellitesListModel
import com.akcay.satellite.util.DividerItemDecorator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SatellitesListFragment : BaseFragment<FragmentSatellitesListBinding, SatellitesListViewModel>(
    FragmentSatellitesListBinding::inflate
) {
    private val satelliteAdapter by lazy { SatellitesListAdapter() }
    override fun getViewModelClass(): Class<SatellitesListViewModel> =
        SatellitesListViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeUi()
    }

    private fun initializeUi() {
        val satelliteList = listOf(
            SatellitesListModel(0, true, "asd"),
            SatellitesListModel(1, true, "asdasdasd"),
            SatellitesListModel(2, true, "asdasda")
        )
        satelliteAdapter.differ.submitList(satelliteList)
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