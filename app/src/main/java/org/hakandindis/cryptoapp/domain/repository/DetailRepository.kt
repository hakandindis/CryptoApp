package org.hakandindis.cryptoapp.domain.repository

import org.hakandindis.cryptoapp.data.remote.model.detail.DetailResponse

/**
 * CREATED BY HAKAN DINDIŞ on 30.12.2023
 */
interface DetailRepository {
    suspend fun getCoinDetail(apiKey: String, symbol: String): DetailResponse
}