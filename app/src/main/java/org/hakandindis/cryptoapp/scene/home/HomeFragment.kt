package org.hakandindis.cryptoapp.scene.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.hakandindis.cryptoapp.base.BaseFragment
import org.hakandindis.cryptoapp.data.remote.model.coin.Coin
import org.hakandindis.cryptoapp.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel by viewModels<HomeViewModel>()
    private val adapter by lazy {
        CoinAdapter(object : ItemClickListener {
            override fun onItemClick(coin: Coin) {
                if (coin.symbol != null) {
                    val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(coin.symbol)
                    findNavController().navigate(action)
                }
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializeListeners()
        initializeObservers()
    }

    private fun initializeViews() {
        binding.coinList.adapter = this.adapter
        viewModel.getLatestCoins()
    }

    private fun initializeListeners() {
    }

    private fun initializeObservers() {
        viewModel.coins.observe(viewLifecycleOwner) {
            it?.let { adapter.submitList(it) }
        }
    }
}