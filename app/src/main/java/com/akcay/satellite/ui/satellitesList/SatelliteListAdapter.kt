package com.akcay.satellite.ui.satellitesList

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.akcay.satellite.R
import com.akcay.satellite.databinding.ItemSatelliteBinding
import com.akcay.satellite.feature.satellites.domain.entities.SatelliteListModel

class SatelliteListAdapter : RecyclerView.Adapter<SatelliteListAdapter.SatelliteViewHolder>() {

    inner class SatelliteViewHolder(private val binding: ItemSatelliteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(satelliteItem: SatelliteListModel) {
            binding.rowSatellite.run {
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

    var clickListener: (id: Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SatelliteViewHolder {
        val view = ItemSatelliteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SatelliteViewHolder(view)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: SatelliteViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    private val differCallback = object : DiffUtil.ItemCallback<SatelliteListModel>() {
        override fun areItemsTheSame(
            oldItem: SatelliteListModel,
            newItem: SatelliteListModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: SatelliteListModel,
            newItem: SatelliteListModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)


}