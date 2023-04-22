package org.hakandindis.cryptoapp.data.remote.service

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface CoinService {
    //https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest


    @GET("/v1/cryptocurrency/listings/latest")
    suspend fun getLatestCoins(
        @Header("X-CMC_PRO_API_KEY") apiKey: String,
        @Query("limit") limit: String
    )
}