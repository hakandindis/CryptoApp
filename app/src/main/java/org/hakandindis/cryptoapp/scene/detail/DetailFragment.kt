package org.hakandindis.cryptoapp.scene.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import org.hakandindis.cryptoapp.base.BaseFragment
import org.hakandindis.cryptoapp.data.remote.model.detail.CoinDetail
import org.hakandindis.cryptoapp.data.remote.model.detail.DetailResponse
import org.hakandindis.cryptoapp.databinding.FragmentDetailBinding
import org.hakandindis.cryptoapp.extensions.loadImage
import org.json.JSONArray
import org.json.JSONObject

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(
    FragmentDetailBinding::inflate
) {

    private val viewModel by viewModels<DetailViewModel>()
    private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializeListeners()
        initializeObservers()
    }

    override fun initializeViews() {

    }

    override fun initializeListeners() {
        viewModel.getDetail(args.symbol)
    }

    override fun initializeObservers() {
        viewModel.detailResponse.observe(viewLifecycleOwner) {
            if (it != null) parseData(it)
        }
    }

    private fun parseData(response: DetailResponse) {
        val gson = Gson()
        val json = gson.toJson(response.data)

        val jsonObject = JSONObject(json)
        val jsonArray = jsonObject[args.symbol] as JSONArray

        val coin = gson.fromJson(jsonArray.getJSONObject(0).toString(), CoinDetail::class.java)

        coin?.let {
            binding.coinIcon.loadImage(coin.id.toString())
            binding.coinName.text = coin.name
            binding.coinDescription.text = coin.description
        }

    }
}