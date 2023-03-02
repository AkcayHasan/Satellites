package com.akcay.satellite.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.akcay.satellite.databinding.RowSatelliteBinding

class SatelliteItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttribute: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttribute) {

    private val binding: RowSatelliteBinding = RowSatelliteBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    init {
        onInitialized()
    }

    var onClickListener: () -> Unit = {}

    private fun onInitialized() {
        binding.run {
            llMainItem.setOnClickListener { onClickListener.invoke() }
        }
    }

    fun setSatelliteNameText(name: String) {
        binding.tvSatelliteName.text = name
    }

    fun setSatelliteStatusText(status: String) {
        binding.tvSatelliteStatus.text = status
    }

    fun setSatelliteNameColor(color: Int) {
        binding.tvSatelliteName.setTextColor(color)
    }

    fun setSatelliteStatusColor(color: Int) {
        binding.tvSatelliteStatus.setTextColor(color)
    }

    fun setSatelliteStatusDotsDrawable(src: Drawable?) {
        binding.ivSatelliteStatusDots.setImageDrawable(src)
    }
}