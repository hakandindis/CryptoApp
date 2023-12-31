package org.hakandindis.cryptoapp.scene.home

import android.os.Bundle
import android.util.Log
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
                    val action =
                        HomeFragmentDirections.actionHomeFragmentToDetailFragment(coin.symbol)
                    findNavController().navigate(action)
                }
            }

            override fun onSaveClick(coin: Coin) {
                viewModel.insertCoin(coin)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializeListeners()
        initializeObservers()
    }

    override fun initializeViews() {
        binding.coinList.adapter = this.adapter
    }

    override fun initializeListeners() {
        viewModel.getLatestCoins()
    }

    override fun initializeObservers() {
        viewModel.coins.observe(viewLifecycleOwner) {
            it?.let { it ->
                adapter.submitList(it)
            }
        }

        viewModel.savedCoins.observe(viewLifecycleOwner) {
            it?.let { coins ->
                coins.map { coin ->
                    Log.d("HAKAN", coin.toString())
                }
                Log.d("HAKAN", "----------------------------")
            }
        }
    }
}