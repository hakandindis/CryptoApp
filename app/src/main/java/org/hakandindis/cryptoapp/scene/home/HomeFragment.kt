package org.hakandindis.cryptoapp.scene.home

import android.util.Log
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.hakandindis.cryptoapp.base.BaseFragment
import org.hakandindis.cryptoapp.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel by viewModels<HomeViewModel>()
    override fun initializeListeners() {
        viewModel.getLatestCoins()
    }

    override fun initializeObservers() {
        viewModel.coins.observe(viewLifecycleOwner) {
            Log.d("HAKAN", "COIN OBSERVE")
            it?.let {
                it.forEach { coin ->
                    Log.d("HAKAN", coin.toString())
                }
            }
        }
    }
}