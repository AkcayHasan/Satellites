package com.akcay.satellite.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.akcay.satellite.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun showLoadingBar() {
        binding.run {
            progressBar.isVisible = true
            fragmentContainerView.isVisible = false
        }
    }

    fun showListOfItems() {
        binding.run {
            progressBar.isVisible = false
            fragmentContainerView.isVisible = true
        }
    }
}