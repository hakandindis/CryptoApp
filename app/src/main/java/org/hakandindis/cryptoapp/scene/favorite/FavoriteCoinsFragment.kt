package org.hakandindis.cryptoapp.scene.favorite

import android.os.Bundle
import android.view.View
import org.hakandindis.cryptoapp.base.BaseFragment
import org.hakandindis.cryptoapp.databinding.FragmentFavoriteCoinsBinding


class FavoriteCoinsFragment : BaseFragment<FragmentFavoriteCoinsBinding>(FragmentFavoriteCoinsBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializeListeners()
        initializeObservers()
    }

    private fun initializeViews() {}
    private fun initializeListeners() {}
    private fun initializeObservers() {}
}