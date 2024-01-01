package org.hakandindis.cryptoapp.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.hakandindis.cryptoapp.data.remote.model.coin.Coin
import org.hakandindis.cryptoapp.data.remote.service.CoinService
import org.hakandindis.cryptoapp.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val service: CoinService,
) : HomeRepository {

    override suspend fun getLatestCoins(apiKey: String, limit: String): List<Coin?>? = withContext(Dispatchers.IO) {
        val response = service.getLatestCoins(apiKey, limit)
        return@withContext response.data
    }
}