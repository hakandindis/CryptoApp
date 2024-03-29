package org.hakandindis.cryptoapp.domain.repository

import org.hakandindis.cryptoapp.data.remote.model.coin.Coin

/**
 * CREATED BY HAKAN DINDIŞ on 30.12.2023
 */
interface HomeRepository {

    suspend fun getLatestCoins(apiKey: String, limit: String): List<Coin?>?
}