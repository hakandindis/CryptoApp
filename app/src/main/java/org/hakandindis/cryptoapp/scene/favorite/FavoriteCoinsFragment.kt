package org.hakandindis.cryptoapp.scene.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.hakandindis.cryptoapp.base.BaseFragment
import org.hakandindis.cryptoapp.databinding.FragmentFavoriteCoinsBinding
import org.hakandindis.cryptoapp.scene.home.CoinAdapter
import org.hakandindis.cryptoapp.scene.home.HomeFragmentDirections

@AndroidEntryPoint
class FavoriteCoinsFragment : BaseFragment<FragmentFavoriteCoinsBinding>(FragmentFavoriteCoinsBinding::inflate) {
    private val viewModel by viewModels<FavoriteCoinsViewModel>()
    private val adapter by lazy {
        CoinAdapter {
            it.symbol?.let { symbol ->
                val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(symbol)
                findNavController().navigate(action)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializeListeners()
        initializeObservers()
    }

    private fun initializeViews() {
        binding.favoriteCoinsRecyclerView.adapter = adapter
        viewModel.getAllFavoriteCoins()
    }

    private fun initializeListeners() {}
    private fun initializeObservers() {
        viewModel.favoriteCoins.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) adapter.submitList(it)
        }
    }
}