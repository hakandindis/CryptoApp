package org.hakandindis.cryptoapp.scene.detail

import android.util.Log
import org.hakandindis.cryptoapp.data.remote.model.detail.DetailResponse
import org.hakandindis.cryptoapp.data.remote.service.CoinService
import javax.inject.Inject

class DetailRepository @Inject constructor(private val coinService: CoinService) {

    suspend fun getCoinDetail(
        apiKey: String,
        symbol: String
    ) = coinService.getCoinInfo(apiKey, symbol)

}