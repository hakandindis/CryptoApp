package org.hakandindis.cryptoapp.domain.repository

import org.hakandindis.cryptoapp.data.local.entity.CoinEntity

/**
 * CREATED BY HAKAN DINDIŞ on 1.01.2024
 */
interface FavoriteCoinsRepository {
    suspend fun getAllFavoriteCoins(): List<CoinEntity>?
}