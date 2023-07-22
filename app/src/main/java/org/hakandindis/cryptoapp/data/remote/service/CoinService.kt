package org.hakandindis.cryptoapp.data.remote.service

import org.hakandindis.cryptoapp.data.remote.model.coin.CoinResponse
import org.hakandindis.cryptoapp.data.remote.model.detail.DetailResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface CoinService {
    @GET("/v1/cryptocurrency/listings/latest")
    suspend fun getLatestCoins(@Header("X-CMC_PRO_API_KEY") apiKey: String, @Query("limit") limit: String): CoinResponse

    @GET("/v2/cryptocurrency/info")
    suspend fun getCoinInfo(@Header("X-CMC_PRO_API_KEY") apiKey: String, @Query("symbol") symbol: String): DetailResponse
}