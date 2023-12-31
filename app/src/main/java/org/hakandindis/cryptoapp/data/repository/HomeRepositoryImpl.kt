package org.hakandindis.cryptoapp.data.repository

import android.util.Log
import org.hakandindis.cryptoapp.data.local.dao.CoinDao
import org.hakandindis.cryptoapp.data.local.entity.CoinEntity
import org.hakandindis.cryptoapp.data.remote.model.coin.Coin
import org.hakandindis.cryptoapp.data.remote.service.CoinService
import org.hakandindis.cryptoapp.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val coinService: CoinService,
    private val coinDao: CoinDao
) : HomeRepository {

    override suspend fun getLatestCoins(apiKey: String, limit: String): List<Coin?>? {
        try {
            val coinResponse = coinService.getLatestCoins(apiKey, limit)
            return coinResponse.data
        } catch (e: Exception) {
            Log.d("HAKAN", e.message.toString())
        }
        return emptyList()
    }

    override suspend fun insertCoin(coin: Coin) {
        coinDao.insertCoin(
            CoinEntity(
                id = coin.id,
                name = coin.name,
                symbol = coin.symbol,
                price = coin.quote?.uSD?.price
            )
        )
    }

    override suspend fun getAllSavedCoins() = coinDao.getAllCoins()

}