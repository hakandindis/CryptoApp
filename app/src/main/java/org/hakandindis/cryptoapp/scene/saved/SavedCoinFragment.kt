package org.hakandindis.cryptoapp.scene.saved

import android.os.Bundle
import android.view.View
import org.hakandindis.cryptoapp.base.BaseFragment
import org.hakandindis.cryptoapp.databinding.FragmentSavedCoinBinding


class SavedCoinFragment :
    BaseFragment<FragmentSavedCoinBinding>(FragmentSavedCoinBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializeListeners()
        initializeObservers()
    }

    override fun initializeViews() {

    }

    override fun initializeListeners() {
    }

    override fun initializeObservers() {
    }

}