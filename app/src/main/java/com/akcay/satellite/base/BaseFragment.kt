package com.akcay.satellite.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.akcay.satellite.ui.main.MainActivity

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(
    private val bindingInflater: (inflater: LayoutInflater) -> VB
) : Fragment() {

    private var _binding: VB? = null

    val binding: VB
        get() = _binding as VB

    protected val viewModel: VM by lazy { ViewModelProvider(this)[getViewModelClass()] }
    protected abstract fun getViewModelClass(): Class<VM>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        if (_binding == null)
            throw IllegalArgumentException("Binding can not be null!")
        initializeUi()
        observeViewModel()
        return binding.root
    }

    abstract fun initializeUi()
    abstract fun observeViewModel()

    fun showLoadingBar() {
        (this.activity as MainActivity).showLoadingBar()
    }

    fun showListOfItems() {
        (this.activity as MainActivity).showListOfItems()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}