package org.hakandindis.cryptoapp.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.hakandindis.cryptoapp.data.remote.service.CoinService
import org.hakandindis.cryptoapp.domain.repository.DetailRepository
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val coinService: CoinService
) : DetailRepository {

    override suspend fun getCoinDetail(apiKey: String, symbol: String) = withContext(Dispatchers.IO) {
        return@withContext coinService.getCoinInfo(apiKey, symbol)
    }
}