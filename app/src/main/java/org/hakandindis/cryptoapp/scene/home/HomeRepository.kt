package org.hakandindis.cryptoapp.scene.home

import android.util.Log
import org.hakandindis.cryptoapp.data.local.dao.CoinDao
import org.hakandindis.cryptoapp.data.local.model.coin.CoinEntity
import org.hakandindis.cryptoapp.data.remote.model.coin.Coin
import org.hakandindis.cryptoapp.data.remote.service.CoinService
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val coinService: CoinService,
    private val coinDao: CoinDao
) {

    suspend fun getLatestCoins(apiKey: String, limit: String): List<Coin?>? {
        try {
            val coinResponse = coinService.getLatestCoins(apiKey, limit)
            return coinResponse.data
        } catch (e: Exception) {
            Log.d("HAKAN", e.message.toString())
        }
        return emptyList()
    }

    suspend fun insertCoin(coin: Coin) {
        coinDao.insertCoin(
            CoinEntity(
                id = coin.id,
                name = coin.name,
                symbol = coin.symbol,
                price = coin.quote?.uSD?.price
            )
        )
    }

    suspend fun getAllSavedCoins() = coinDao.getAllCoins()

}