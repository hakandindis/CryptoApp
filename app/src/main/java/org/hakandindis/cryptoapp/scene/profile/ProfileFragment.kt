package org.hakandindis.cryptoapp.scene.profile

import android.os.Bundle
import android.view.View
import org.hakandindis.cryptoapp.base.BaseFragment
import org.hakandindis.cryptoapp.databinding.FragmentProfileBinding


class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializeListeners()
        initializeObservers()
    }

    fun initializeViews() {
    }

    fun initializeListeners() {
    }

    fun initializeObservers() {
    }

}