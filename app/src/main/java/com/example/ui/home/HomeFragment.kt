package com.example.ui.home

import com.example.R
import com.example.common.BaseFragment
import com.example.common.obtainViewModel
import com.example.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(), HomeActionListener {

    private val viewModel: HomeViewModel? by lazy {
        obtainViewModel(HomeViewModel::class.java)
    }

    override val contentLayoutId: Int
        get() = R.layout.fragment_home

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun setupBinding(binding: FragmentHomeBinding) {
        binding.apply {
            listener = this@HomeFragment
            viewModel = this@HomeFragment.viewModel
        }
    }

    override fun setupViewModel() {
        viewModel?.start()
    }

    override fun onNextClicked() {
        viewModel?.onNextClicked()
    }
}