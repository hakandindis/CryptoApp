package org.hakandindis.cryptoapp.scene.home

import android.util.Log
import org.hakandindis.cryptoapp.data.remote.model.coin.Coin
import org.hakandindis.cryptoapp.data.remote.service.CoinService
import javax.inject.Inject

class HomeRepository @Inject constructor(private val coinService: CoinService) {

    suspend fun getLatestCoins(apiKey: String, limit: String): List<Coin?>? {
        try {
            val coinResponse = coinService.getLatestCoins(apiKey, limit)
            return coinResponse.data
        } catch (e: Exception) {
            Log.d("HAKAN", e.message.toString())
        }
        return emptyList()
    }

}