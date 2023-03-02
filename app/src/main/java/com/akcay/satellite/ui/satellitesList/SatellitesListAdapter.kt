package com.akcay.satellite.ui.satellitesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.akcay.satellite.R
import com.akcay.satellite.base.BaseAdapter
import com.akcay.satellite.databinding.ItemSatelliteBinding
import com.akcay.satellite.feature.satellites.domain.entities.SatellitesListModel

class SatellitesListAdapter : BaseAdapter<SatellitesListModel, ItemSatelliteBinding>() {

    override fun createBinding(parent: ViewGroup): ItemSatelliteBinding =
        ItemSatelliteBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

    override fun bind(binding: ItemSatelliteBinding, item: SatellitesListModel?, position: Int) {
        binding.rowSatellite.run {
            item?.let { satelliteItem ->
                if (satelliteItem.active) {
                    setSatelliteStatusText(binding.root.context.getString(R.string.satellite_active))
                    setSatelliteNameColor(
                        ResourcesCompat.getColor(
                            binding.root.resources,
                            R.color.black,
                            null
                        )
                    )
                    setSatelliteStatusColor(
                        ResourcesCompat.getColor(
                            binding.root.resources,
                            R.color.black,
                            null
                        )
                    )
                    setSatelliteStatusDotsDrawable(
                        ResourcesCompat.getDrawable(
                            binding.root.resources,
                            R.drawable.green_dot,
                            null
                        )
                    )
                } else {
                    setSatelliteStatusText(binding.root.context.getString(R.string.satellite_passive))
                    setSatelliteNameColor(
                        ResourcesCompat.getColor(
                            binding.root.resources,
                            R.color.passive_gray,
                            null
                        )
                    )
                    setSatelliteStatusColor(
                        ResourcesCompat.getColor(
                            binding.root.resources,
                            R.color.passive_gray,
                            null
                        )
                    )
                    setSatelliteStatusDotsDrawable(
                        ResourcesCompat.getDrawable(
                            binding.root.resources,
                            R.drawable.red_dot,
                            null
                        )
                    )
                }
                setSatelliteNameText(satelliteItem.name)
                onClickListener = { clickListener.invoke(satelliteItem.id) }
            }
        }
    }
}